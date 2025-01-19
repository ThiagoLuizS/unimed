package br.com.seguro.unimed.models.dto.form;

import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoForm {
    private Long produtoId;
    private Integer quantidade;
}
