package br.com.seguro.unimed.models.dto.view;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoView {
    private Long id;
    private String nome;
    private BigDecimal preco;
}
