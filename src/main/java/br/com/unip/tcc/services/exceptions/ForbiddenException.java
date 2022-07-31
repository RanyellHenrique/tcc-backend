package br.com.unip.tcc.services.exceptions;

import lombok.Data;

@Data
public class ForbiddenException extends RuntimeException {

    public ForbiddenException(String msg) {
        super(msg);
    }
}
