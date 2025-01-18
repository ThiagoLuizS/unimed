package br.com.seguro.unimed.models.domain;

import br.com.seguro.unimed.models.enums.StatusPedidoEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_pedido")
public class Pedido {
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
    @Column(name = "data_criacao")
    private Date dataCriacao;
    @Enumerated(EnumType.STRING)
    private StatusPedidoEnum status;
}
