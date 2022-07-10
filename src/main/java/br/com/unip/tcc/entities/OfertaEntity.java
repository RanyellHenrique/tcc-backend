package br.com.unip.tcc.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tb_oferta")
public class OfertaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String subTitulo;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    private LocalDateTime dataDeCadastro;
    private LocalDateTime dataDeAtualizacao;
    private BigDecimal preco;
    private Boolean ativa;

    @ManyToOne
    private ClienteEntity cliente;

    @OneToOne
    private EnderecoEntity endereco;

    @PrePersist
    public void prePersist() {
        dataDeCadastro = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        dataDeAtualizacao = LocalDateTime.now();
    }
}
