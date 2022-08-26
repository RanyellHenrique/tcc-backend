package br.com.unip.tcc.dtos.responses;

import br.com.unip.tcc.entities.enums.EstadoPropostaEnum;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PropostaResponse {

    private Long id;
    private TrabalhadorResponse trabalhador;
    private OfertaResponse oferta;
    private EstadoPropostaEnum estado;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String analiseDescricao;
    private AvaliacaoResponse avaliacao;
}
