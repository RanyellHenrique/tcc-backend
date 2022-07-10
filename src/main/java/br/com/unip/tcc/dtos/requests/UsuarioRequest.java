package br.com.unip.tcc.dtos.requests;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioRequest {

    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private LocalDate dataDeNascimento;
    private String descricao;
    private String urlImagem;
    private EnderecoRequest endereco;
}
