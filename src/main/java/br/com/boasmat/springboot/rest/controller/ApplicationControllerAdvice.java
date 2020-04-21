package br.com.boasmat.springboot.rest.controller;

import br.com.boasmat.springboot.exception.RegraNegocioException;
import br.com.boasmat.springboot.rest.ApiErros;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(RegraNegocioException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros handlerRegraNegocioException(RegraNegocioException ex){
        String message = ex.getMessage();
        return  new ApiErros(message);
    }

}
