package br.com.boasmat.springboot;

import br.com.boasmat.springboot.domain.entity.Pedido;
import br.com.boasmat.springboot.service.PedidoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VendasApplication {
    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}
