package br.com.boasmat.springboot.domain.repository;

import br.com.boasmat.springboot.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//@Repository // não precisa pois já está informando dentro do JPAREPOSITORY
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    //query methods
    List<Cliente> findByNomeLike(String nome);

    List<Cliente> findByNomeOrIdOrderById(String nome, Integer id);

    Cliente findOneByNome(String nome);

    boolean existsByNome(String nome);

    //Consulta por HQL
    @Query(value = " SELECT c FROM Cliente c WHERE c.nome LIKE :nome")
    List<Cliente> encontrarPorNomeHQL(@Param("nome") String nome);

    @Query(value = " SELECT * FROM Cliente c WHERE c.nome LIKE '%:nome%'", nativeQuery = true)
    List<Cliente> encontrarPorNomeSqlNativo(@Param("nome") String nome);

//    @Query("DELETE FROM Cliente c WHERE c.nome =:nome")
//    @Modifying
//// falar que não é de consulta - atualizar e deletar
//    void deleteByNome(String nome);

    @Query("SELECT c FROM Cliente c LEFT JOIN FETCH c.pedidos WHERE c.id =:id")
    Cliente findClienteFetchPedidos(@Param("id") Integer id);

}

