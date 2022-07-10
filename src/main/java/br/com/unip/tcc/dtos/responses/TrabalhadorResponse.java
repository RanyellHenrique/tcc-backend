package br.com.unip.tcc.dtos.responses;

import lombok.Data;

@Data
public class TrabalhadorResponse extends UsuarioResponse {

    private String cpf;
}
