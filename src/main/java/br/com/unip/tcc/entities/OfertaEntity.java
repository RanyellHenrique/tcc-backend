package br.com.unip.tcc.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne(cascade = CascadeType.MERGE)
    private ClienteEntity cliente;

    @OneToOne(cascade = CascadeType.ALL)
    private EnderecoEntity endereco;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "tb_oferta_categoria",
            joinColumns = @JoinColumn(name = "oferta_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<CategoriaEntity> categorias = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        dataDeCadastro = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        dataDeAtualizacao = LocalDateTime.now();
    }
}
