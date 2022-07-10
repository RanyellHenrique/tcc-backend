package br.com.unip.tcc.dtos.requests;

import lombok.Data;

@Data
public class TrabalhadorRequest extends UsuarioRequest {

    private String cpf;
}
