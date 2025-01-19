package br.com.seguro.unimed.service;

import br.com.seguro.unimed.exception.GlobalException;
import br.com.seguro.unimed.models.dto.form.ProdutoForm;
import br.com.seguro.unimed.models.dto.view.ProdutoView;
import br.com.seguro.unimed.service.impl.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;


public class ProdutoServiceTest extends AbstractServiceTest {

    @Autowired
    private ProdutoService produtoService;

    @Test
    void salvarComSucesso() {
        ProdutoForm produtoForm = ProdutoForm.builder()
                .nome("teste")
                .preco(BigDecimal.ONE)
                .build();

        ProdutoView view = produtoService.saveToView(produtoForm);

        assertThat(view.getId()).isNotNull();
    }

    @Test
    void validarNomeInexistente() {
        ProdutoForm produtoForm = ProdutoForm.builder()
                .nome("")
                .preco(BigDecimal.ONE)
                .build();

        try {
            produtoService.saveToView(produtoForm);
        } catch (Exception e) {
            assertThat(e).isExactlyInstanceOf(GlobalException.class);
            assertThat(e.getMessage()).contains("[Column 'nome' cannot be null]");
        }
    }

    @Test
    void validarPrecoInexistente() {
        ProdutoForm produtoForm = ProdutoForm.builder()
                .nome("teste")
                .build();

        try {
            produtoService.saveToView(produtoForm);
        } catch (Exception e) {
            assertThat(e).isExactlyInstanceOf(GlobalException.class);
            assertThat(e.getMessage()).contains("[Column 'preco' cannot be null]");
        }
    }

    @Test
    void salvarEBuscarProdutoSalvoComSucesso() {
        ProdutoForm produtoForm = ProdutoForm.builder()
                .nome("teste")
                .preco(BigDecimal.ONE)
                .build();

        ProdutoView view = produtoService.saveToView(produtoForm);

        assertThat(view.getId()).isNotNull();

        ProdutoView produtoSalvoView = produtoService.getByIdToView(view.getId());

        assertThat(produtoSalvoView).isNotNull();
    }

    @Test
    void salvarEBuscarProdutoSalvoPaginadoComSucesso() {
        ProdutoForm produtoForm = ProdutoForm.builder()
                .nome("teste")
                .preco(BigDecimal.ONE)
                .build();

        ProdutoView view = produtoService.saveToView(produtoForm);

        assertThat(view.getId()).isNotNull();

        Page<ProdutoView> page = produtoService.getAll(Pageable.ofSize(10));

        assertThat(page.getTotalPages()).isNotZero();
    }
}
