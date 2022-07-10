package br.com.unip.tcc.dtos.requests;

import lombok.Data;

@Data
public class EnderecoRequest {

    private String cep;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
}
