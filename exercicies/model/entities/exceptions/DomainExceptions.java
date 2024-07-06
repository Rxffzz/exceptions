package model.entities.exceptions;

import java.io.Serial;

public class DomainExceptions extends Exception{
    @Serial
    private static final long serialVersionUID = 1L;

    public DomainExceptions(String mensagem){
        super(mensagem);
    }
}
