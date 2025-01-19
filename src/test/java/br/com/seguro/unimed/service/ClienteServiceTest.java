package br.com.seguro.unimed.service;

import br.com.seguro.unimed.exception.GlobalException;
import br.com.seguro.unimed.models.dto.form.ClienteForm;
import br.com.seguro.unimed.models.dto.view.ClienteView;
import br.com.seguro.unimed.service.impl.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest
public class ClienteServiceTest {

    @Container
    private static final MySQLContainer<?> MYSQL_CONTAINER = new MySQLContainer<>("mysql:8.0")
            .withDatabaseName("testdb")
            .withUsername("testuser")
            .withPassword("testpass");

    @Autowired
    private ClienteService clienteService;

    @DynamicPropertySource
    static void setProperties(org.springframework.test.context.DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", MYSQL_CONTAINER::getJdbcUrl);
        registry.add("spring.datasource.username", MYSQL_CONTAINER::getUsername);
        registry.add("spring.datasource.password", MYSQL_CONTAINER::getPassword);
    }

    @Test
    void salvarComSucesso() {
        ClienteForm clienteForm = ClienteForm.builder()
                .nome("teste")
                .email("teste@gmail.com")
                .build();

        ClienteView view = clienteService.save(clienteForm);

        assertThat(view.getId()).isNotNull();
    }

    @Test
    void validarEmailInexistente() {
        ClienteForm clienteForm = ClienteForm.builder()
                .nome("teste")
                .build();

        try {
            clienteService.save(clienteForm);
        } catch (Exception e) {
            assertThat(e).isExactlyInstanceOf(GlobalException.class);
            assertThat(e.getMessage()).contains("[Column 'email' cannot be null]");
        }
    }

    @Test
    void validarNomeInexistente() {
        ClienteForm clienteForm = ClienteForm.builder()
                .nome("")
                .email("teste@gmail.com")
                .build();

        try {
            clienteService.save(clienteForm);
        } catch (Exception e) {
            assertThat(e).isExactlyInstanceOf(GlobalException.class);
            assertThat(e.getMessage()).contains("[Column 'nome' cannot be null]");
        }
    }

    @Test
    void salvarEBuscarClienteSalvoComSucesso() {
        ClienteForm clienteForm = ClienteForm.builder()
                .nome("teste")
                .email("teste@gmail.com")
                .build();

        ClienteView view = clienteService.save(clienteForm);

        assertThat(view.getId()).isNotNull();

        ClienteView clienteSalvoView = clienteService.getById(view.getId());

        assertThat(clienteSalvoView).isNotNull();
    }

    @Test
    void salvarEBuscarClienteSalvoPaginadoComSucesso() {
        ClienteForm clienteForm = ClienteForm.builder()
                .nome("teste")
                .email("teste@gmail.com")
                .build();

        ClienteView view = clienteService.save(clienteForm);

        assertThat(view.getId()).isNotNull();

        Page<ClienteView> page = clienteService.getAll(Pageable.ofSize(10));

        assertThat(page.getTotalPages()).isNotZero();
    }
}
