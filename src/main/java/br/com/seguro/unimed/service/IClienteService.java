package br.com.seguro.unimed.service;

import br.com.seguro.unimed.models.domain.Cliente;
import br.com.seguro.unimed.models.dto.form.ClienteForm;
import br.com.seguro.unimed.models.dto.view.ClienteView;

public interface IClienteService extends IService<Cliente, ClienteView, ClienteForm> {
}
