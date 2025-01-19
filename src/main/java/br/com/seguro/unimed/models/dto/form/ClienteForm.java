package br.com.seguro.unimed.models.dto.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ClienteForm {
    @NotBlank(message = "Nome obrigatório")
    private String nome;
    @Email(message = "E-mail inválido")
    @NotBlank(message = "E-mail obrigatório")
    private String email;
}
