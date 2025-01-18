package br.com.seguro.unimed.models.domain;

import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_produto")
public class Produto {
    private Long id;
    private String nome;
    private BigDecimal preco;
}
