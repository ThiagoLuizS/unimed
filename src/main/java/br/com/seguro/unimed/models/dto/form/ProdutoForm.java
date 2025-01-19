package br.com.seguro.unimed.models.dto.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoForm {
    @NotBlank(message = "Nome obrigatório")
    private String nome;
    @NotNull(message = "Preço obrigatório")
    private BigDecimal preco;
}
