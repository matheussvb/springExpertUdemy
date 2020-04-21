package br.com.boasmat.springboot.service;

import br.com.boasmat.springboot.domain.entity.Pedido;
import br.com.boasmat.springboot.res.dto.PedidoDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PedidoService {

    Pedido salvar(PedidoDTO dto);
    Optional<Pedido> obterPedidoCompleto(Integer id);

}
