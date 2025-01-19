package br.com.seguro.unimed.service.impl;

import br.com.seguro.unimed.models.domain.Cliente;
import br.com.seguro.unimed.models.dto.form.ClienteForm;
import br.com.seguro.unimed.models.dto.view.ClienteView;
import br.com.seguro.unimed.models.mapper.ClienteMapper;
import br.com.seguro.unimed.models.mapper.MapStructMapper;
import br.com.seguro.unimed.repository.ClienteRepository;
import br.com.seguro.unimed.service.AbstractService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClienteService extends AbstractService<Cliente, ClienteView, ClienteForm> {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Override
    protected JpaRepository<Cliente, Long> getRepository() {
        return clienteRepository;
    }

    @Override
    protected MapStructMapper<Cliente, ClienteView, ClienteForm> getMapper() {
        return clienteMapper;
    }
}
