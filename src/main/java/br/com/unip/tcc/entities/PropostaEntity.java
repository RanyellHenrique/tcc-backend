package br.com.unip.tcc.entities;

import br.com.unip.tcc.entities.enums.EstadoPropostaEnum;
import br.com.unip.tcc.entities.pk.PropostaEntityPK;
import lombok.Data;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tb_proposta")
public class PropostaEntity {

    @Generated(GenerationTime.INSERT)
    @Column(unique = true, columnDefinition="serial")
    private Long id;
    @EmbeddedId
    private PropostaEntityPK propostaPK;
    @Enumerated(EnumType.ORDINAL)
    private EstadoPropostaEnum estado;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    private LocalDateTime dataDeCadastro;
    private LocalDateTime dataDeAtualizacao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    @Column(columnDefinition = "TEXT")
    private String analiseDescricao;

    @OneToOne(mappedBy = "proposta", cascade = CascadeType.ALL)
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
