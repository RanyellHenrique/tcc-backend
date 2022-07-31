package br.com.unip.tcc.dtos.requests;

import br.com.unip.tcc.entities.enums.EstadoPropostaEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PropostaAnaliseRequest {

    @NotNull
    private Long idOferta;
    @NotNull
    private Long idTrabalhador;
    @NotNull
    private EstadoPropostaEnum estado;
    @NotBlank
    private String analiseDescricao;
}
