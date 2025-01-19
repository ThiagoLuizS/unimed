package br.com.seguro.unimed.models.mapper;

import br.com.seguro.unimed.models.domain.Produto;
import br.com.seguro.unimed.models.dto.form.ProdutoForm;
import br.com.seguro.unimed.models.dto.view.ProdutoView;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", config = MapStructMapper.class)
public interface ProdutoMapper extends MapStructMapper<Produto, ProdutoView, ProdutoForm> {
    @Override
    @Mapping(target = "id", ignore = true)
    Produto formToEntity(ProdutoForm produtoForm);
}
