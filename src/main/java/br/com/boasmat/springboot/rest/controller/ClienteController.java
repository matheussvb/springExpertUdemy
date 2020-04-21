package br.com.boasmat.springboot.rest.controller;

import br.com.boasmat.springboot.domain.entity.Cliente;
import br.com.boasmat.springboot.domain.repository.ClientesRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClientesRespository clientesRespository;

    @ResponseBody
    @GetMapping("/{id}")
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

    @PostMapping
    @ResponseBody
    public ResponseEntity save(@RequestBody Cliente cliente) {
        Cliente clienteSave = clientesRespository.save(cliente);
        return ResponseEntity.ok(clienteSave);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        Optional<Cliente> cliente = clientesRespository.findById(id);
        if (cliente.isPresent()) {
            clientesRespository.delete(cliente.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @ResponseBody
    @PutMapping("/{id}")
    public ResponseEntity upDate(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
        return clientesRespository
                .findById(id).map(clienteExistente -> { //procura um cliente pelo id
                    cliente.setId(clienteExistente.getId());// pega o id antigo e seta no novo cliente "atualizando" ele
                    clientesRespository.save(cliente); // salva o cliente
                    return ResponseEntity.noContent().build(); // o map precisa retornar o tipo do metodo
                }).orElseGet(() -> ResponseEntity.notFound().build()); // se não encontra então retorna 404
    }


}
