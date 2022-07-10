package br.com.unip.tcc.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "tb_avaliacao")
public class AvaliacaoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private Long nota;

    @OneToOne
    private PropostaEntity proposta;
}
