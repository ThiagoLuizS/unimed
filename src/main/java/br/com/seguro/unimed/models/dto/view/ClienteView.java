package br.com.seguro.unimed.models.dto.view;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ClienteView {
    private Long id;
    private String nome;
    private String email;
    @JsonManagedReference
    private List<PedidoView> pedidos;
}
