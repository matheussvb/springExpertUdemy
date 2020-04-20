package br.com.boasmat.springboot.service;

import br.com.boasmat.springboot.model.Cliente;
import br.com.boasmat.springboot.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    public void salvarCliente(Cliente cliente) {
        validarCliente(cliente);

    }

    public void validarCliente(Cliente cliente) {

    }
}
