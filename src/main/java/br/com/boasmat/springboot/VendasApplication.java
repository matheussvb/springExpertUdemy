package br.com.boasmat.springboot;

import br.com.boasmat.springboot.domain.entity.Cliente;
import br.com.boasmat.springboot.domain.entity.Pedido;
import br.com.boasmat.springboot.domain.repository.ClientesRespository;
import br.com.boasmat.springboot.domain.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Autowired
    private ClientesRespository clientesRespository;

    @Autowired
    private PedidosRepository pedidosRepository;

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

    @Bean
    public CommandLineRunner executar() {
        return args -> {
            System.out.println("Salvando Clientes");
            clientesRespository.save(new Cliente("Matheus"));
            Cliente fulano = new Cliente("Fulano");
            clientesRespository.save(fulano);


            Pedido p = new Pedido();
            p.setCliente(fulano);
            p.setDataPedido(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(100));

            pedidosRepository.save(p);
//
//            Cliente clienteFetchPedidos = clientesRespository.findClienteFetchPedidos(fulano.getId());
//            System.out.println(clienteFetchPedidos.getPedidos());

            List<Pedido> pedidoFulano = pedidosRepository.findByCliente(fulano);
            pedidoFulano.forEach(fulanoPedido -> {
                System.out.println(fulanoPedido);
            });

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
