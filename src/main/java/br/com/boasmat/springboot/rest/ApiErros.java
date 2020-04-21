package br.com.boasmat.springboot.rest;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
public class ApiErros {

    @Getter
    private List<String> errors;

    public ApiErros(String mensagemErro) {
        this.errors = Arrays.asList(mensagemErro);
    }


}
