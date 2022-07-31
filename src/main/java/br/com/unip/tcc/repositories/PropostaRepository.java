package br.com.unip.tcc.repositories;

import br.com.unip.tcc.entities.PropostaEntity;
import br.com.unip.tcc.entities.pk.PropostaEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropostaRepository extends JpaRepository<PropostaEntity, PropostaEntityPK> {
}
