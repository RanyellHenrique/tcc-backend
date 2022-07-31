package br.com.unip.tcc.dtos.requests;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PropostaRequest {
    
    private Long idOferta;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
}
