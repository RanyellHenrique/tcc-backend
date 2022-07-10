package br.com.unip.tcc.dtos.responses;

import lombok.Data;

@Data
public class ClienteResponse extends UsuarioResponse {

    private String cnpj;
}
