package br.com.seguro.unimed.controller;

import br.com.seguro.unimed.models.domain.ItemPedido;
import br.com.seguro.unimed.models.dto.form.ItemPedidoForm;
import br.com.seguro.unimed.models.dto.view.ItemPedidoView;
import br.com.seguro.unimed.resource.ItemPedidoResource;
import br.com.seguro.unimed.service.AbstractService;
import br.com.seguro.unimed.service.impl.ItemPedidoService;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/itens-pedido")
public class ItemPedidoController extends AbstractController<ItemPedido, ItemPedidoView, ItemPedidoForm> implements ItemPedidoResource {

    private final ItemPedidoService service;

    @Override
    protected AbstractService<ItemPedido, ItemPedidoView, ItemPedidoForm> getService() {
        return service;
    }

    @Override
    @Hidden //Este método direto não funcionará então estou ocultando ele da minha documentação swagger
    public ItemPedidoView save(ItemPedidoForm itemPedidoForm) {
        return super.save(itemPedidoForm);
    }

    @Override
    public List<ItemPedidoView> salvarItensPedido(Long pedidoId, List<ItemPedidoForm> itensPedidoForm) {
        return service.salvarItensPedido(pedidoId, itensPedidoForm);
    }
}
