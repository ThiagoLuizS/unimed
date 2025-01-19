package br.com.seguro.unimed.service.impl;

import br.com.seguro.unimed.models.domain.Cliente;
import br.com.seguro.unimed.models.domain.Pedido;
import br.com.seguro.unimed.models.dto.form.PedidoForm;
import br.com.seguro.unimed.models.dto.view.PedidoView;
import br.com.seguro.unimed.models.enums.StatusPedidoEnum;
import br.com.seguro.unimed.models.mapper.MapStructMapper;
import br.com.seguro.unimed.models.mapper.PedidoMapper;
import br.com.seguro.unimed.repository.PedidoRepository;
import br.com.seguro.unimed.service.AbstractService;
import br.com.seguro.unimed.service.IPedidoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class PedidoService extends AbstractService<Pedido, PedidoView, PedidoForm> implements IPedidoService {

    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidoMapper;
    private final ClienteService clienteService;

    @Override
    protected JpaRepository<Pedido, Long> getRepository() {
        return pedidoRepository;
    }

    @Override
    protected MapStructMapper<Pedido, PedidoView, PedidoForm> getMapper() {
        return pedidoMapper;
    }

    @Override
    @Transactional
    public PedidoView salvarPedido(Long clienteId) {
        log.info("Salvando pedido [clienteId={}]", clienteId);
        Cliente cliente = clienteService.getById(clienteId);

        PedidoForm pedidoForm = PedidoForm.builder()
                .cliente(cliente)
                .dataCriacao(new Date())
                .status(StatusPedidoEnum.CRIADO)
                .build();

        return saveToView(pedidoForm);
    }
}
