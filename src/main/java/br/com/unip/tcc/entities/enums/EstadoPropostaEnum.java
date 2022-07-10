package br.com.unip.tcc.entities.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum EstadoPropostaEnum {

    ABERTA(1L, "Aberta"),
    FECHADA(2L, "Fechada"),
    RECUSADA(3L, "Recusada"),
    EM_EXECUCAO(4L, "Em Execução"),
    CONCLUIDA(5L, "Concluida");

    private final Long id;
    private final String descricao;
}
