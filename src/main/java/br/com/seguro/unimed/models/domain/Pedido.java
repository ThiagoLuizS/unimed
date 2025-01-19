package br.com.seguro.unimed.models.domain;

import br.com.seguro.unimed.models.enums.StatusPedidoEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ItemPedido> itemPedidos = new ArrayList<>();
}
