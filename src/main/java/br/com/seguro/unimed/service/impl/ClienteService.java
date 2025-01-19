package br.com.seguro.unimed.service.impl;

import br.com.seguro.unimed.exception.GlobalException;
import br.com.seguro.unimed.models.domain.Cliente;
import br.com.seguro.unimed.models.dto.form.ClienteForm;
import br.com.seguro.unimed.models.dto.view.ClienteView;
import br.com.seguro.unimed.models.mapper.ClienteMapper;
import br.com.seguro.unimed.models.mapper.MapStructMapper;
import br.com.seguro.unimed.repository.ClienteRepository;
import br.com.seguro.unimed.service.AbstractService;
import br.com.seguro.unimed.service.IClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClienteService extends AbstractService<Cliente, ClienteView, ClienteForm> implements IClienteService {

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

    @Override
    @Transactional
    public ClienteView save(ClienteForm clienteForm) {
        return saveToView(clienteForm);
    }

    @Override
    public ClienteView getById(Long id) {
        return getRepository().findById(id)
                .map(getMapper()::entityToView)
                .orElseThrow(() -> new GlobalException("Cliente não encontrado"));
    }

    @Override
    public Page<ClienteView> getAll(Pageable pageable) {
        return getRepository()
                .findAll(pageable)
                .map(getMapper()::entityToView);
    }
}
