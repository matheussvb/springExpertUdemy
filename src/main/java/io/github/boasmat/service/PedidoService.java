package io.github.boasmat.service;

import io.github.boasmat.domain.entity.Pedido;
import io.github.boasmat.domain.enums.StatusPedido;
import io.github.boasmat.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar( PedidoDTO dto );
    Optional<Pedido> obterPedidoCompleto(Integer id);
}
