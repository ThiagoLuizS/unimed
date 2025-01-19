package br.com.seguro.unimed.service;

import br.com.seguro.unimed.models.dto.view.PedidoView;

public interface IPedidoService {
    PedidoView salvarPedido(Long clienteId);
}
