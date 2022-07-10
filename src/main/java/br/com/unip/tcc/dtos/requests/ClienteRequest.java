package br.com.unip.tcc.dtos.requests;

import lombok.*;

@Data
public class ClienteRequest extends UsuarioRequest {

    private String cnpj;
}
