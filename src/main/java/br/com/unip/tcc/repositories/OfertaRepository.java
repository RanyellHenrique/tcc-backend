package br.com.unip.tcc.repositories;

import br.com.unip.tcc.entities.OfertaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfertaRepository extends JpaRepository<OfertaEntity, Long> {

    @Query("SELECT DISTINCT obj FROM OfertaEntity obj INNER JOIN obj.categorias cats WHERE "
            + "(:categoria IS NULL OR :categoria IN cats.id ) AND "
            + "(:titulo = '' OR LOWER(obj.titulo) LIKE LOWER(CONCAT('%',:titulo,'%') )) "
            + "AND obj.ativa = true")
    Page<OfertaEntity> findAllPage(Long categoria, String titulo, Pageable pageable);

    OfertaEntity findOfertaById(Long id);
}
