package br.com.seguro.unimed.service;

import br.com.seguro.unimed.exception.GlobalException;
import br.com.seguro.unimed.models.dto.form.ClienteForm;
import br.com.seguro.unimed.models.dto.form.ItemPedidoForm;
import br.com.seguro.unimed.models.dto.form.ProdutoForm;
import br.com.seguro.unimed.models.dto.view.ClienteView;
import br.com.seguro.unimed.models.dto.view.ItemPedidoView;
import br.com.seguro.unimed.models.dto.view.PedidoView;
import br.com.seguro.unimed.models.dto.view.ProdutoView;
import br.com.seguro.unimed.service.impl.ClienteService;
import br.com.seguro.unimed.service.impl.ItemPedidoService;
import br.com.seguro.unimed.service.impl.PedidoService;
import br.com.seguro.unimed.service.impl.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemPedidoServiceTest extends AbstractServiceTest {

    @Autowired
    private ItemPedidoService itemPedidoService;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private ClienteService clienteService;

    @Test
    void criarItemPedidoCompletoComSucesso() {

        /**
         * Criar Produtos
         * */
        ProdutoForm produtoForm1 = ProdutoForm.builder().nome("produto1").preco(BigDecimal.ZERO).build();
        ProdutoForm produtoForm2 = ProdutoForm.builder().nome("produto2").preco(BigDecimal.ONE).build();

        ProdutoView produtoView1 = produtoService.saveToView(produtoForm1);
        assertThat(produtoView1.getId()).isNotNull();

        ProdutoView produtoView2 = produtoService.saveToView(produtoForm2);
        assertThat(produtoView2.getId()).isNotNull();

        /**
         * Criar Cliente e Pedido
         * */
        ClienteForm clienteForm = ClienteForm.builder()
                .nome("teste")
                .email("teste@gmail.com")
                .build();

        ClienteView clienteView = clienteService.saveToView(clienteForm);

        assertThat(clienteView.getId()).isNotNull();

        PedidoView pedidoView = pedidoService.salvarPedido(clienteView.getId());

        assertThat(pedidoView.getId()).isNotNull();

        ItemPedidoForm itemPedido1 = ItemPedidoForm.builder()
                .quantidade(1)
                .produtoId(produtoView1.getId())
                .build();

        ItemPedidoForm itemPedido2 = ItemPedidoForm.builder()
                .quantidade(1)
                .produtoId(produtoView2.getId())
                .build();

        List<ItemPedidoView> itemPedidoViews = itemPedidoService.salvarItensPedido(pedidoView.getId(), List.of(itemPedido1, itemPedido2));

        assertThat(itemPedidoViews).isNotEmpty();
    }

    @Test
    void criarItemPedidoCompletoInexistente() {

        /**
         * Criar Cliente e Pedido
         * */
        ClienteForm clienteForm = ClienteForm.builder()
                .nome("teste")
                .email("teste@gmail.com")
                .build();

        ClienteView clienteView = clienteService.saveToView(clienteForm);

        assertThat(clienteView.getId()).isNotNull();

        PedidoView pedidoView = pedidoService.salvarPedido(clienteView.getId());

        assertThat(pedidoView.getId()).isNotNull();

        ItemPedidoForm itemPedido1 = ItemPedidoForm.builder()
                .quantidade(1)
                .produtoId(55555L)
                .build();

        ItemPedidoForm itemPedido2 = ItemPedidoForm.builder()
                .quantidade(1)
                .produtoId(66666L)
                .build();
        try {
            itemPedidoService.salvarItensPedido(pedidoView.getId(), List.of(itemPedido1, itemPedido2));
        }catch (Exception e) {
            assertThat(e).isExactlyInstanceOf(GlobalException.class);
            assertThat(e.getMessage()).contains(messageNotFound);
        }

    }
}
