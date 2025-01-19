package br.com.seguro.unimed.models.dto.view;

import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoView {
    private Long id;
    private Long pedidoId;
    private ProdutoView produto;
    private Integer quantidade;
}
