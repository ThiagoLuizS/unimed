package br.com.seguro.unimed.service;

import br.com.seguro.unimed.models.dto.view.PedidoView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPedidoService {
    PedidoView salvarPedido(Long clienteId);
    Page<PedidoView> getAllByClienteId(Long clienteId, Pageable pageable);
}
