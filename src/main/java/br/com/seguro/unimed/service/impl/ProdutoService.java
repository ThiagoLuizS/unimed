package br.com.seguro.unimed.service.impl;

import br.com.seguro.unimed.models.domain.Produto;
import br.com.seguro.unimed.models.dto.form.ProdutoForm;
import br.com.seguro.unimed.models.dto.view.ProdutoView;
import br.com.seguro.unimed.models.mapper.MapStructMapper;
import br.com.seguro.unimed.models.mapper.ProdutoMapper;
import br.com.seguro.unimed.repository.ProdutoRepository;
import br.com.seguro.unimed.service.AbstractService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProdutoService extends AbstractService<Produto, ProdutoView, ProdutoForm> {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    @Override
    protected JpaRepository<Produto, Long> getRepository() {
        return produtoRepository;
    }

    @Override
    protected MapStructMapper<Produto, ProdutoView, ProdutoForm> getMapper() {
        return produtoMapper;
    }
}
