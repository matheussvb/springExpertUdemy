package br.com.boasmat.springboot.domain.repository;

import br.com.boasmat.springboot.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedido extends JpaRepository<ItemPedido, Integer> {
}
