package br.com.unip.tcc.dtos.requests;

import lombok.Data;

@Data
public class AvaliacaoTrabalhadorRequest {

    private String descricao;
    private Long nota;
    private Long idOferta;
}
