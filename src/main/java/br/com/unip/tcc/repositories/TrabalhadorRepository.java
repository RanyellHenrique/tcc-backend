package br.com.unip.tcc.repositories;

import br.com.unip.tcc.entities.TrabalhadorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabalhadorRepository extends JpaRepository<TrabalhadorEntity, Long> {

    TrabalhadorEntity findByEmail(String email);

    @Query("SELECT DISTINCT obj FROM TrabalhadorEntity obj INNER JOIN obj.categorias cats WHERE "
            + "(:categoria IS NULL OR :categoria IN cats.id ) AND"
            + "(:nome = '' OR LOWER(obj.nome) LIKE LOWER(CONCAT('%',:nome,'%') ))")
    Page<TrabalhadorEntity> findAllPage(Long categoria, String nome, Pageable pageable);
}
