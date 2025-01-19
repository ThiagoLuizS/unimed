package br.com.seguro.unimed.models.dto.view;

import br.com.seguro.unimed.models.enums.StatusPedidoEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.ArrayList;
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
    private List<ItemPedidoView> itemPedidos = new ArrayList<>();
}
