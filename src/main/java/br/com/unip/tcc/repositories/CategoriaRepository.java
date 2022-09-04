package br.com.unip.tcc.repositories;

import br.com.unip.tcc.entities.CategoriaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {

    @Query("SELECT DISTINCT obj FROM CategoriaEntity obj WHERE "
            + "(:nome = '' OR LOWER(obj.nome) LIKE LOWER(CONCAT('%',:nome,'%') )) ")
    Page<CategoriaEntity> findAllPageByNome(String nome, Pageable pageable);
}
