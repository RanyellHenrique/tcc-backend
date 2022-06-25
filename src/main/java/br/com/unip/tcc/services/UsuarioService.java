package br.com.unip.tcc.services;

import br.com.unip.tcc.dtos.requests.UsuarioRequest;
import br.com.unip.tcc.dtos.responses.UsuarioResponse;
import br.com.unip.tcc.entities.UsuarioEntity;
import br.com.unip.tcc.mappers.UsuarioMapper;
import br.com.unip.tcc.repositories.UsuarioRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public record UsuarioService(UsuarioMapper mapper, UsuarioRepository repository) {

    public UsuarioResponse insert(UsuarioRequest request) {
        var usuario = repository.save(mapper.toUsuarioEntity(request));
        return mapper.toUsuarioResponse(usuario);
    }

    public List<UsuarioResponse> findAll() {
        return repository.findAll().stream()
                .map(mapper::toUsuarioResponse)
                .collect(Collectors.toList());
    }

    public Optional<UsuarioResponse> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toUsuarioResponse);
    }

    public Optional<UsuarioResponse> update(Long id, UsuarioRequest request) {
        Optional<UsuarioEntity> usuario = repository.findById(id);
        if (usuario.isEmpty()) {
            return Optional.empty();
        }
        setUsuario(usuario.get(), request);
        return Optional.of(mapper.toUsuarioResponse(repository.save(usuario.get())));
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new IllegalArgumentException("Id not found " + id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Integrity violation");
        }
    }

    private void setUsuario(UsuarioEntity entity, UsuarioRequest request) {
        entity.setDescricao(request.getDescricao());
        entity.setNome(request.getNome());
    }
}
