package br.com.boasmat.springboot.rest.controller;

import br.com.boasmat.springboot.domain.entity.Cliente;
import br.com.boasmat.springboot.domain.repository.ClientesRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
//@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClientesRespository clientesRespository;

    @ResponseBody
    @GetMapping("/api/clientes/{id}")
    public ResponseEntity getClienteById(@PathVariable("id") Integer id) {
        Optional<Cliente> cliente = clientesRespository.findById(id);
        if (cliente.isPresent()) {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Authorization", "token");
            ResponseEntity<Cliente> responseEntity =
                    new ResponseEntity<Cliente>(cliente.get(), httpHeaders, HttpStatus.OK);

            return ResponseEntity.ok(cliente.get());
        }
        return ResponseEntity.notFound().build();
    }

}
