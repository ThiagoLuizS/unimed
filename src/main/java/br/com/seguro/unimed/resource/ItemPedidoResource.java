package br.com.seguro.unimed.resource;

import br.com.seguro.unimed.models.dto.form.ItemPedidoForm;
import br.com.seguro.unimed.models.dto.view.ItemPedidoView;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ItemPedidoResource {
    @PostMapping("/pedido/{pedidoId}")
    List<ItemPedidoView> salvarItensPedido(Long pedidoId, @Valid @RequestBody List<ItemPedidoForm> itensPedidoForm);
}
