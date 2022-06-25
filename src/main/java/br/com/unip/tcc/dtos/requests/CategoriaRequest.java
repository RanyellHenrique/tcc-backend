package br.com.unip.tcc.dtos.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CategoriaRequest {

    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
}
