package br.com.unip.tcc.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private LocalDate dataDeNascimento;
    private LocalDateTime dataDeCadastro;
    private LocalDateTime dataDeAtualizacao;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    private String urlImagem;

    @PrePersist
    public void prePersist() {
        dataDeCadastro = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        dataDeAtualizacao = LocalDateTime.now();
    }
}
