package br.com.boasmat.springboot.domain.repository;

import br.com.boasmat.springboot.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@Repository // não precisa pois já está informando dentro do JPAREPOSITORY
public interface Clientes extends JpaRepository<Cliente, Integer> {
    //query methods
    List<Cliente> findByNomeLike(String nome);

    List<Cliente> findByNomeOrIdOrderById(String nome, Integer id);

    Cliente findOneByNome(String nome);

    boolean existsByNomeLike(String nome);




}

