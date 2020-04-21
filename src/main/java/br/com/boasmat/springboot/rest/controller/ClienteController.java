package br.com.boasmat.springboot.rest.controller;

import br.com.boasmat.springboot.domain.entity.Cliente;
import br.com.boasmat.springboot.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clientesRespository;

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable("id") Integer id) {
        return clientesRespository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Cliente não encontrado"));


//        Optional<Cliente> cliente = clientesRespository.findById(id);
//        if (cliente.isPresent()) {
//            HttpHeaders httpHeaders = new HttpHeaders();
//            httpHeaders.set("Authorization", "token");
//            ResponseEntity<Cliente> responseEntity =
//                    new ResponseEntity<Cliente>(cliente.get(), httpHeaders, HttpStatus.OK);
//
//            return ResponseEntity.ok(cliente.get());
//        }
//        return ResponseEntity.notFound().build();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 2o1
    public Cliente save(@RequestBody Cliente cliente) {
        return clientesRespository.save(cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        clientesRespository.findById(id)
                .map(cliente -> {
                    clientesRespository.delete(cliente);
                    return cliente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Cliente não encontrado"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void upDate(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
        clientesRespository.findById(id)
                .map(clienteExistente -> {
                    cliente.setId(clienteExistente.getId());
                    clientesRespository.save(cliente);
                    return clienteExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Cliente não encontrado"));
//        return clientesRespository
//                .findById(id).map(clienteExistente -> { //procura um cliente pelo id
//                    cliente.setId(clienteExistente.getId());// pega o id antigo e seta no novo cliente "atualizando" ele
//                    clientesRespository.save(cliente); // salva o cliente
//                    return ResponseEntity.noContent().build(); // o map precisa retornar o tipo do metodo
//                }).orElseGet(() -> ResponseEntity.notFound().build()); // se não encontra então retorna 404
    }

    @GetMapping
    public List<Cliente> find(Cliente filtro) {
        ExampleMatcher matcher = ExampleMatcher //encontra os clientes pelas propriedades
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher); // pega as propriedades populadas
        return clientesRespository.findAll(example);
    }

//    @GetMapping
//    public ResponseEntity find(Cliente filtro) {
//        ExampleMatcher matcher = ExampleMatcher //encontra os clientes pelas propriedades
//                .matching()
//                .withIgnoreCase()
//                .withStringMatcher(
//                        ExampleMatcher.StringMatcher.CONTAINING);
//        Example example = Example.of(filtro, matcher); // pega as propriedades populadas
//        List<Cliente> lista = clientesRespository.findAll(example);
//        return ResponseEntity.ok(lista);
//    }


}
