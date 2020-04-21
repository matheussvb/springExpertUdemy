package br.com.boasmat.springboot.res.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//{
//        "cliente": 1,
//        "total": 100,
//        "": [
//        {
//        "produto": 1,
//        "quantidade": 10
//        }
//        ]
//}
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoDTO {

    private Integer produto;
    private Integer quantidade;

}
