package br.com.unip.tcc.dtos.requests;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class UsuarioRequest {

    @NotBlank
    private String nome;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String senha;
    @NotBlank
    private String telefone;
    private LocalDate dataDeNascimento;
    private String descricao;
    private String urlImagem;
    @NotNull
    private EnderecoRequest endereco;
}
