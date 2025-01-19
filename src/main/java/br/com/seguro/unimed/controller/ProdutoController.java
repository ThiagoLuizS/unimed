package br.com.seguro.unimed.controller;

import br.com.seguro.unimed.models.domain.Produto;
import br.com.seguro.unimed.models.dto.form.ProdutoForm;
import br.com.seguro.unimed.models.dto.view.ProdutoView;
import br.com.seguro.unimed.service.AbstractService;
import br.com.seguro.unimed.service.impl.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/produtos")
public class ProdutoController extends AbstractController<Produto, ProdutoView, ProdutoForm> {

    private final ProdutoService service;

    @Override
    protected AbstractService<Produto, ProdutoView, ProdutoForm> getService() {
        return service;
    }
}
