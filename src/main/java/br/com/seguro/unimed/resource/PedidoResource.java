package br.com.seguro.unimed.resource;

import br.com.seguro.unimed.models.dto.view.PedidoView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface PedidoResource {

    @PostMapping("/{clienteId}")
    PedidoView salvarPedido(@PathVariable("clienteId") Long clienteId);

    @GetMapping("/filter")
    Page<PedidoView> getAllByClienteId(
            @RequestParam(name = "clienteId", required = false) Long clienteId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size);
}
