package br.com.seguro.unimed.models.mapper;

import br.com.seguro.unimed.models.domain.ItemPedido;
import br.com.seguro.unimed.models.dto.form.ItemPedidoForm;
import br.com.seguro.unimed.models.dto.view.ItemPedidoView;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = MapStructMapper.class)
public interface ItemPedidoMapper extends MapStructMapper<ItemPedido, ItemPedidoView, ItemPedidoForm> {
    @Override
    ItemPedidoView entityToView(ItemPedido t);
}
