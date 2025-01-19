package br.com.seguro.unimed.service;

import br.com.seguro.unimed.models.dto.form.ItemPedidoForm;
import br.com.seguro.unimed.models.dto.view.ItemPedidoView;

import java.util.List;

public interface IItemPedidoService {
    List<ItemPedidoView> salvarItensPedido(Long pedidoId, List<ItemPedidoForm> itensPedidoForm);
}
