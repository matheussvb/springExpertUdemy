package br.com.boasmat.springboot.domain.repository;

import br.com.boasmat.springboot.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produto, Integer> {


}
