package br.com.unip.tcc.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String nome;
    private String descricao;
}
