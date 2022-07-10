package br.com.unip.tcc.dtos.responses;

import lombok.Data;

@Data
public class EnderecoResponse {

    private String cep;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
}
