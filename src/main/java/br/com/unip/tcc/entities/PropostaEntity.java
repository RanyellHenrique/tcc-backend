package br.com.unip.tcc.entities;

import br.com.unip.tcc.entities.enums.EstadoPropostaEnum;
import br.com.unip.tcc.entities.pk.PropostaEntityPK;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tb_proposta")
public class PropostaEntity {

    @EmbeddedId
    private PropostaEntityPK propostaPK;

    @Enumerated(EnumType.ORDINAL)
    private EstadoPropostaEnum estado;

    private String descricao;
    private LocalDateTime dataDeCadastro;
    private LocalDateTime dataDeAtualizacao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String analiseDescricao;

    @OneToOne(mappedBy = "proposta")
    private AvaliacaoEntity avaliacao;

    @PrePersist
    public void prePersist() {
        dataDeCadastro = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        dataDeAtualizacao = LocalDateTime.now();
    }
}
