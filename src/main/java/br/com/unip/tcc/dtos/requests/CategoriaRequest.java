package br.com.unip.tcc.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class CategoriaRequest {

    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
}
