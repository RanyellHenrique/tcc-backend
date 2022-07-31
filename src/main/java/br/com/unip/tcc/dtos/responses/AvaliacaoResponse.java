package br.com.unip.tcc.dtos.responses;

import lombok.Data;

import java.io.Serializable;

@Data
public class AvaliacaoResponse implements Serializable {
    private Long id;
    private String descricao;
    private Long nota;
}
