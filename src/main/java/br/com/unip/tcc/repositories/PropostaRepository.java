package br.com.unip.tcc.repositories;

import br.com.unip.tcc.entities.PropostaEntity;
import br.com.unip.tcc.entities.pk.PropostaEntityPK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PropostaRepository extends JpaRepository<PropostaEntity, PropostaEntityPK> {

    @Query("SELECT obj FROM PropostaEntity obj " +
            "WHERE obj.propostaPK.trabalhador.id = :idTrabalhador " +
            "AND (:idOferta IS NULL OR :idOferta = obj.propostaPK.oferta.id)")
    Page<PropostaEntity> findAllPropostasByTrabalhador(Long idTrabalhador, Long idOferta, Pageable page);


    @Query("SELECT obj FROM PropostaEntity obj " +
            "WHERE obj.propostaPK.oferta.cliente.id = :idCliente " +
            "AND (:idOferta IS NULL OR :idOferta = obj.propostaPK.oferta.id)")
    Page<PropostaEntity> findAllPropostasByCliente(Long idCliente, Long idOferta, Pageable page);
}
