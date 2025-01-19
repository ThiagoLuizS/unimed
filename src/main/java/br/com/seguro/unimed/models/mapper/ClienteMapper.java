package br.com.seguro.unimed.models.mapper;

import br.com.seguro.unimed.models.domain.Cliente;
import br.com.seguro.unimed.models.dto.form.ClienteForm;
import br.com.seguro.unimed.models.dto.view.ClienteView;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = MapStructMapper.class)
public interface ClienteMapper extends MapStructMapper<Cliente, ClienteView, ClienteForm> {
}
