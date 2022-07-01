package br.com.unip.tcc.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_perfil")
public class PerfilEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
}
