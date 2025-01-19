package br.com.seguro.unimed.models.dto.form;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoForm {
    @NotNull(message = "Informe o ID do produto")
    private Long produtoId;
    @NotNull(message = "Informe uma quantidade")
    private Integer quantidade;
}
