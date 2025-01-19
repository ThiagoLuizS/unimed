package br.com.seguro.unimed.resource;

import br.com.seguro.unimed.models.dto.view.PedidoView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface PedidoResource {

    @PostMapping("/{clienteId}")
    PedidoView salvarPedido(@PathVariable("clienteId") Long clienteId);
}
