package br.com.seguro.unimed.controller;

import br.com.seguro.unimed.models.domain.Cliente;
import br.com.seguro.unimed.models.dto.form.ClienteForm;
import br.com.seguro.unimed.models.dto.view.ClienteView;
import br.com.seguro.unimed.resource.IResource;
import br.com.seguro.unimed.service.AbstractService;
import br.com.seguro.unimed.service.impl.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clientes")
public class ClienteController extends AbstractController<Cliente, ClienteView, ClienteForm> implements IResource<Cliente, ClienteView, ClienteForm> {

    private final ClienteService service;

    @Override
    protected AbstractService<Cliente, ClienteView, ClienteForm> getService() {
        return service;
    }
}
