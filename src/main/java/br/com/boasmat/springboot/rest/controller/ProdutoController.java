package br.com.boasmat.springboot.rest.controller;

import br.com.boasmat.springboot.domain.entity.Produto;
import br.com.boasmat.springboot.domain.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutosRepository produtosRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto save(@RequestBody Produto produto) {
        return produtosRepository.save(produto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Integer id, @RequestBody Produto produto) {
        produtosRepository.findById(id)
                .map(p -> {
                    produto.setId(p.getId());
                    produtosRepository.save(produto);
                    return Void.TYPE;
                }).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado")
        );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        produtosRepository.findById(id)
                .map(produto -> {
                    produtosRepository.delete(produto);
                    return Void.TYPE;
                }).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado")
        );
    }


    @GetMapping("/{id}")
    public Produto getById(@PathVariable("id") Integer id) {
        return produtosRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado")
        );
    }

    @GetMapping

    public List<Produto> find(Produto filtro) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING
                );
        Example example = Example.of(filtro, matcher);
        return produtosRepository.findAll(example);
    }
}

