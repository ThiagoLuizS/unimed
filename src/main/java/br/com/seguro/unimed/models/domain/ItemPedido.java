package br.com.seguro.unimed.models.domain;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_item_pedido")
public class ItemPedido {
    private Long id;
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
    @JoinColumn(name = "produto_id")
    private Produto produto;
    private Integer quantidade;
}
