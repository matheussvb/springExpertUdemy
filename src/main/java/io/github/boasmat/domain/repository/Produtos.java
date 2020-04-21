package io.github.boasmat.domain.repository;

import io.github.boasmat.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto,Integer> {
}
