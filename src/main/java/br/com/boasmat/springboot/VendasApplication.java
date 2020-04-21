package br.com.boasmat.springboot;

import br.com.boasmat.springboot.domain.entity.Cliente;
import br.com.boasmat.springboot.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VendasApplication {

    @Autowired
    private Clientes clientes;

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

    @Bean
    public CommandLineRunner executar() {
        return args -> {
            System.out.println("Salvando Clientes");
            clientes.save(new Cliente("Matheus"));
            clientes.save(new Cliente("Outro Cliente"));

            boolean existe = clientes.existsByNomeLike( "Matheus");
            System.out.println("Existe um cliente com o nome Matheus?: " + existe);


//
//            System.out.println("Atualizando Clientes");
//            listClientes.forEach(cli -> {
//                cli.setNome(cli.getNome() + " atualizado. ");
//                clientes.save(cli);
//            });
//
//            System.out.println("Buscando Clientes");
//            clientes.findByNomeLike("cli").forEach(cli -> {
//                System.out.println("filtro por cli: " + cli);
//            });
//
//            listClientes = clientes.findAll();
//            listClientes.forEach(System.out::println);
//
//            System.out.println("deletando Clientes");
//
//            clientes.findAll().forEach(cli -> {
//                System.out.println("Cliente deletado: " + cli);
//                clientes.delete(cli);
//            });
//
//
//            List<Cliente> todosClientes = clientes.findAll();
//            if (todosClientes.isEmpty()) {
//                System.out.println("Nenhum cliente encontrado!");
//            } else {
//                todosClientes.forEach(clien -> {
//                    System.out.println(clien);
//                });
//            }
//        };
        };
    }
}
