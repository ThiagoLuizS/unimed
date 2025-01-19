package br.com.seguro.unimed.service;

import br.com.seguro.unimed.models.dto.form.ClienteForm;
import br.com.seguro.unimed.models.dto.view.ClienteView;
import br.com.seguro.unimed.models.dto.view.PedidoView;
import br.com.seguro.unimed.service.impl.ClienteService;
import br.com.seguro.unimed.service.impl.PedidoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class PedidoServiceTest extends AbstractServiceTest {

    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private ClienteService clienteService;

    @Test
    void criarPedidoComSucesso() {

        ClienteForm clienteForm = ClienteForm.builder()
                .nome("teste")
                .email("teste@gmail.com")
                .build();

        ClienteView clienteView = clienteService.saveToView(clienteForm);

        assertThat(clienteView.getId()).isNotNull();

        PedidoView pedidoView = pedidoService.salvarPedido(clienteView.getId());

        assertThat(pedidoView.getId()).isNotNull();
    }

    @Test
    void salvarEBuscarPedidoSalvoComSucesso() {
        ClienteForm clienteForm = ClienteForm.builder()
                .nome("teste")
                .email("teste@gmail.com")
                .build();

        ClienteView clienteView = clienteService.saveToView(clienteForm);

        assertThat(clienteView.getId()).isNotNull();

        PedidoView pedidoView = pedidoService.salvarPedido(clienteView.getId());

        assertThat(pedidoView.getId()).isNotNull();

        PedidoView pedidoSalvoView = pedidoService.getByIdToView(pedidoView.getId());

        assertThat(pedidoSalvoView).isNotNull();
    }
}
