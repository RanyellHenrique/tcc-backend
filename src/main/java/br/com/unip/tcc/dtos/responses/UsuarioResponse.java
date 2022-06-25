package br.com.unip.tcc.dtos.responses;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioResponse {

    private String id;
    private String nome;
    private String telefone;
    private LocalDate dataDeNascimento;
    private String descricao;
    private String urlImagem;
}
