package br.com.boasmat.springboot.domain.repository;

import br.com.boasmat.springboot.domain.entity.Cliente;
import br.com.boasmat.springboot.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidosRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByCliente(Cliente cliente);

}
