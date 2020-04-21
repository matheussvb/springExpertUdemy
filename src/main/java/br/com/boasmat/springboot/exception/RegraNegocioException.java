package br.com.boasmat.springboot.exception;

public class RegraNegocioException extends  RuntimeException{

    public RegraNegocioException(String msg) {
        super(msg);
    }
}
