package br.com.seguro.unimed.service;

import br.com.seguro.unimed.exception.GlobalException;
import br.com.seguro.unimed.models.dto.form.ClienteForm;
import br.com.seguro.unimed.models.dto.view.ClienteView;
import br.com.seguro.unimed.service.impl.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static org.assertj.core.api.Assertions.assertThat;

public class ClienteServiceTest extends AbstractServiceTest {

    @Autowired
    private ClienteService clienteService;

    @Test
    void salvarComSucesso() {
        ClienteForm clienteForm = ClienteForm.builder()
                .nome("teste")
                .email("teste@gmail.com")
                .build();

        ClienteView view = clienteService.saveToView(clienteForm);

        assertThat(view.getId()).isNotNull();
    }

    @Test
    void validarEmailInexistente() {
        ClienteForm clienteForm = ClienteForm.builder()
                .nome("teste")
                .build();

        try {
            clienteService.saveToView(clienteForm);
        } catch (Exception e) {
            assertThat(e).isExactlyInstanceOf(GlobalException.class);
            assertThat(e.getMessage()).contains(messageErrorConstraint);
        }
    }

    @Test
    void validarNomeInexistente() {
        ClienteForm clienteForm = ClienteForm.builder()
                .nome("")
                .email("teste@gmail.com")
                .build();

        try {
            clienteService.saveToView(clienteForm);
        } catch (Exception e) {
            assertThat(e).isExactlyInstanceOf(GlobalException.class);
            assertThat(e.getMessage()).contains(messageErrorConstraint);
        }
    }

    @Test
    void salvarEBuscarClienteSalvoComSucesso() {
        ClienteForm clienteForm = ClienteForm.builder()
                .nome("teste")
                .email("teste@gmail.com")
                .build();

        ClienteView view = clienteService.saveToView(clienteForm);

        assertThat(view.getId()).isNotNull();

        ClienteView clienteSalvoView = clienteService.getByIdToView(view.getId());

        assertThat(clienteSalvoView).isNotNull();
    }

    @Test
    void salvarEBuscarClienteSalvoPaginadoComSucesso() {
        ClienteForm clienteForm = ClienteForm.builder()
                .nome("teste")
                .email("teste@gmail.com")
                .build();

        ClienteView view = clienteService.saveToView(clienteForm);

        assertThat(view.getId()).isNotNull();

        Page<ClienteView> page = clienteService.getAll(Pageable.ofSize(10));

        assertThat(page.getTotalPages()).isNotZero();
    }
}
