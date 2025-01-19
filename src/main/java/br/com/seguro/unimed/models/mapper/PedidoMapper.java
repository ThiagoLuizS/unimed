package br.com.seguro.unimed.models.mapper;

import br.com.seguro.unimed.models.domain.Pedido;
import br.com.seguro.unimed.models.dto.form.PedidoForm;
import br.com.seguro.unimed.models.dto.view.PedidoView;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", config = MapStructMapper.class)
public interface PedidoMapper extends MapStructMapper<Pedido, PedidoView, PedidoForm> {
    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "itemPedidos", ignore = true)
    Pedido formToEntity(PedidoForm pedidoForm);
}
