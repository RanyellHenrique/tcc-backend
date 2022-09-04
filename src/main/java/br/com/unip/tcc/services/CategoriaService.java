package br.com.unip.tcc.services;

import br.com.unip.tcc.dtos.requests.CategoriaRequest;
import br.com.unip.tcc.dtos.responses.CategoriaResponse;
import br.com.unip.tcc.entities.CategoriaEntity;
import br.com.unip.tcc.mappers.CategoriaMapper;
import br.com.unip.tcc.repositories.CategoriaRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public record CategoriaService(CategoriaMapper mapper, CategoriaRepository repository) {

    public CategoriaResponse insert(CategoriaRequest request) {
        var categoria = repository.save(mapper.toCategoriaEntity(request));
        return mapper.toCategoriaResponse(categoria);
    }

    public List<CategoriaResponse> findAll() {
        return repository.findAll().stream()
                .map(mapper::toCategoriaResponse)
                .collect(Collectors.toList());
    }

    public Page<CategoriaResponse> findAllPage(String nome, Pageable pageable) {
        return repository.findAllPageByNome(nome, pageable)
                .map(mapper::toCategoriaResponse);
    }

    public Optional<CategoriaResponse> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toCategoriaResponse);
    }

    public Optional<CategoriaResponse> update(Long id, CategoriaRequest request) {
        Optional<CategoriaEntity> categoria = repository.findById(id);
        if (categoria.isEmpty()) {
            return Optional.empty();
        }
        setCategoria(categoria.get(), request);
        return Optional.of(mapper.toCategoriaResponse(repository.save(categoria.get())));
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

    private void setCategoria(CategoriaEntity entity, CategoriaRequest request) {
        entity.setDescricao(request.getDescricao());
        entity.setNome(request.getNome());
    }
}
