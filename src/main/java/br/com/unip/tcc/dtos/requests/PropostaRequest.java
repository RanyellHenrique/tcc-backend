package br.com.unip.tcc.dtos.requests;

import lombok.Data;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class PropostaRequest {

    @NotNull
    private Long idOferta;
    @NotBlank
    private String descricao;
    @FutureOrPresent
    @NotNull
    private LocalDate dataInicio;
    @FutureOrPresent
    @NotNull
    private LocalDate dataFim;
}
