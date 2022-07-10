package br.com.unip.tcc.repositories;

import br.com.unip.tcc.entities.ClienteEntity;
import br.com.unip.tcc.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    ClienteEntity findByEmail(String email);

}
