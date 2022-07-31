package br.com.unip.tcc.entities.pk;

import br.com.unip.tcc.entities.OfertaEntity;
import br.com.unip.tcc.entities.TrabalhadorEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serial;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropostaEntityPK implements Serializable {

    @Serial
    private static final long serialVersionUID = -8652421159552123477L;

    @ManyToOne
    private TrabalhadorEntity trabalhador;

    @ManyToOne
    private OfertaEntity oferta;
}
