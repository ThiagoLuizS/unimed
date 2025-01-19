package br.com.seguro.unimed.models.dto.form;

import br.com.seguro.unimed.models.enums.StatusPedidoEnum;
import lombok.*;

import java.util.Date;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PedidoForm {
    private Long clienteId;
    private Date dataCriacao;
    private StatusPedidoEnum status;
}
