package br.com.unip.tcc.dtos.responses;

import lombok.Data;

@Data
public class CategoriaResponse {

    private Long id;
    private String nome;
    private String descricao;
}
