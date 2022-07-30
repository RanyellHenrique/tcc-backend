package br.com.unip.tcc.dtos.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EnderecoRequest {

    @NotBlank
    private String cep;
    private String complemento;
    @NotBlank
    private String bairro;
    @NotBlank
    private String localidade;
    @NotBlank
    private String uf;
}
