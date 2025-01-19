package br.com.seguro.unimed.models.dto.view;

import br.com.seguro.unimed.models.enums.StatusPedidoEnum;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PedidoView {
    private Long id;
    private Date dataCriacao;
    private StatusPedidoEnum status;
    private List<ItemPedidoView> itemPedidos;
}
