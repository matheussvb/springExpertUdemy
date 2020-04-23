package io.github.boasmat.rest.dto;

import io.github.boasmat.validation.NotEmptyList;
import io.github.boasmat.validation.TotalMaiorQue100;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    @NotNull(message = "Informe o nome do cliente")
    private Integer cliente;

    @NotNull(message = "Campo total do pedido é obrigatório")
    @TotalMaiorQue100
    private BigDecimal total;

    @NotEmptyList(message = "Pedido não pode ser realizado sem itens")
    private List<ItemPedidoDTO> itens;

}
