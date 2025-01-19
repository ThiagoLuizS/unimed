package br.com.seguro.unimed.models.dto.form;

import br.com.seguro.unimed.annotation.ValueOfEnum;
import br.com.seguro.unimed.models.enums.StatusPedidoEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PedidoForm {
    @ValueOfEnum(enumClass = StatusPedidoEnum.class, message = "Opção inválida, informe CRIADO/EM_ANDAMENTO/FINALIZADO")
    private String status;
}
