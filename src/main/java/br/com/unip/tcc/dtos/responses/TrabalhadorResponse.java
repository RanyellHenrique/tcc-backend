package br.com.unip.tcc.dtos.responses;

import lombok.Data;

import java.util.List;

@Data
public class TrabalhadorResponse extends UsuarioResponse {

    private String cpf;
    private List<CategoriaResponse> categorias;
}
