package br.com.seguro.unimed.service.impl;

import br.com.seguro.unimed.exception.GlobalException;
import br.com.seguro.unimed.models.domain.Produto;
import br.com.seguro.unimed.models.dto.form.ProdutoForm;
import br.com.seguro.unimed.models.dto.view.ProdutoView;
import br.com.seguro.unimed.models.mapper.MapStructMapper;
import br.com.seguro.unimed.models.mapper.ProdutoMapper;
import br.com.seguro.unimed.repository.ProdutoRepository;
import br.com.seguro.unimed.service.AbstractService;
import br.com.seguro.unimed.service.IProdutoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProdutoService extends AbstractService<Produto, ProdutoView, ProdutoForm> implements IProdutoService {

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

    @Override
    public ProdutoView save(ProdutoForm produtoForm) {
        return saveToView(produtoForm);
    }

    @Override
    public ProdutoView getById(Long id) {
        return getRepository().findById(id)
                .map(getMapper()::entityToView)
                .orElseThrow(() -> new GlobalException("Produto não encontrado."));
    }

    @Override
    public Page<ProdutoView> getAll(Pageable pageable) {
        return getRepository()
                .findAll(pageable)
                .map(getMapper()::entityToView);
    }
}
