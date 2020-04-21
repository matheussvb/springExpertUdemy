package br.com.boasmat.springboot;

import br.com.boasmat.springboot.domain.entity.Cliente;
import br.com.boasmat.springboot.domain.repository.RepositoryClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner executar(@Autowired RepositoryClientes repositoryClientes){
        return args -> {

            System.out.println("Salvando Clientes");
            Cliente cliente = new Cliente("Matheus");

            Cliente cliente2 = new Cliente("outro cliente");

            repositoryClientes.salvar(cliente);
            repositoryClientes.salvar(cliente2);

            List<Cliente> clientes = repositoryClientes.obterTodos();
            clientes.forEach(System.out::println);

            System.out.println("Atualizando Clientes");
            clientes.forEach(cli -> {
                cli.setNome(cli.getNome() + " atualizado. ");
                repositoryClientes.atualizar(cli);
            });

            System.out.println("Buscando Clientes");
            repositoryClientes.buscarPorNome("cli").forEach(cli -> {
                System.out.println("filtro por cli: " + cli);
            });

            clientes = repositoryClientes.obterTodos();
            clientes.forEach(System.out::println);

            System.out.println("deletando Clientes");

//            repositoryClientes.obterTodos().forEach(cli -> {
//                System.out.println("Cliente deletado: " + cli);
//                repositoryClientes.deletar(cli);
//            });

            List<Cliente> todosClientes = repositoryClientes.obterTodos();
            if(todosClientes.isEmpty()){
                System.out.println("Nenhum cliente encontrado!");
            } else {
                todosClientes.forEach(clien -> {
                    System.out.println(clien);
                });
            }


        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
