package br.com.boasmat.springboot;

import br.com.boasmat.springboot.domain.entity.Cliente;
import br.com.boasmat.springboot.domain.repository.ClientesRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VendasApplication {
    @Autowired
    public ClientesRespository clientesRespository;

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

    @Bean
    public CommandLineRunner exec() {
        return args -> {
            Cliente cliente = new Cliente();
            cliente.setNome("Fulano");
            clientesRespository.save(cliente);
        };
    }
}
