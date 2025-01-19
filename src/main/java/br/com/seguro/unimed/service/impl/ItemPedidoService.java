package br.com.seguro.unimed.service.impl;

import br.com.seguro.unimed.models.domain.ItemPedido;
import br.com.seguro.unimed.models.domain.Pedido;
import br.com.seguro.unimed.models.domain.Produto;
import br.com.seguro.unimed.models.dto.form.ItemPedidoForm;
import br.com.seguro.unimed.models.dto.view.ItemPedidoView;
import br.com.seguro.unimed.models.mapper.ItemPedidoMapper;
import br.com.seguro.unimed.models.mapper.MapStructMapper;
import br.com.seguro.unimed.repository.ItemPedidoRepository;
import br.com.seguro.unimed.service.AbstractService;
import br.com.seguro.unimed.service.IItemPedidoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemPedidoService extends AbstractService<ItemPedido, ItemPedidoView, ItemPedidoForm> implements IItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;
    private final ItemPedidoMapper itemPedidoMapper;
    private final PedidoService pedidoService;
    private final ProdutoService produtoService;

    @Override
    protected JpaRepository<ItemPedido, Long> getRepository() {
        return itemPedidoRepository;
    }

    @Override
    protected MapStructMapper<ItemPedido, ItemPedidoView, ItemPedidoForm> getMapper() {
        return itemPedidoMapper;
    }

    @Override
    @Transactional
    public List<ItemPedidoView> salvarItensPedido(Long pedidoId, List<ItemPedidoForm> itensPedidoForm) {
        log.info("Salvando pedido: {}", pedidoId);
        Pedido pedido = pedidoService.getById(pedidoId);
        log.info("Pedido: {}", pedido);

        List<ItemPedido> itensPedido = new ArrayList<>();

        itensPedidoForm.forEach(itemForm -> {
            Produto produto = produtoService.getById(itemForm.getProdutoId());
            ItemPedido itemPedido = ItemPedido.builder()
                    .produto(produto)
                    .quantidade(itemForm.getQuantidade())
                    .pedido(pedido)
                    .build();
            itensPedido.add(itemPedido);
        });

        log.info("ItensPedido: {}", itensPedido);

        List<ItemPedidoView> itensPedidoSalvo = itensPedido.stream().map(this::saveEntityToView).toList();

        log.info("ItensPedido Salvo: {}", itensPedido);

        return itensPedidoSalvo;
    }
}
