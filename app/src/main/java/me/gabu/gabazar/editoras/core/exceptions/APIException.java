package me.gabu.gabazar.editoras.core.exceptions;

public class APIException extends RuntimeException{

    public APIException(String mensagem) {
        super(mensagem);
    }

    private static final long serialVersionUID = 1L;

}
