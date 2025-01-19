package br.com.seguro.unimed.controller;

import br.com.seguro.unimed.models.domain.Pedido;
import br.com.seguro.unimed.models.dto.form.PedidoForm;
import br.com.seguro.unimed.models.dto.view.PedidoView;
import br.com.seguro.unimed.resource.PedidoResource;
import br.com.seguro.unimed.service.AbstractService;
import br.com.seguro.unimed.service.impl.PedidoService;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pedidos")
public class PedidoController extends AbstractController<Pedido, PedidoView, PedidoForm> implements PedidoResource {

    private final PedidoService service;

    @Override
    protected AbstractService<Pedido, PedidoView, PedidoForm> getService() {
        return service;
    }

    @Override
    @Hidden //Este método direto não funcionará então estou ocultando ele da minha documentação swagger
    public PedidoView save(PedidoForm pedidoForm) {
        return super.save(pedidoForm);
    }

    @Override
    public PedidoView salvarPedido(Long clienteId) {
        return service.salvarPedido(clienteId);
    }

    @Override
    public Page<PedidoView> getAllByClienteId(Long clienteId, int page, int size) {
        return service.getAllByClienteId(clienteId, PageRequest.of(page, size));
    }
}
