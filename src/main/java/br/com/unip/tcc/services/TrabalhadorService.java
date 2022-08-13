package br.com.unip.tcc.services;

import br.com.unip.tcc.dtos.requests.TrabalhadorRequest;
import br.com.unip.tcc.dtos.responses.TrabalhadorResponse;
import br.com.unip.tcc.entities.PerfilEntity;
import br.com.unip.tcc.entities.TrabalhadorEntity;
import br.com.unip.tcc.mappers.TrabalhadorMapper;
import br.com.unip.tcc.repositories.TrabalhadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrabalhadorService {

    private final TrabalhadorMapper mapper;
    private final TrabalhadorRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;
    private static final Long idPerfilTrabalhador = 3L;

    public TrabalhadorResponse insert(TrabalhadorRequest request) {
        request.setSenha(passwordEncoder.encode(request.getSenha()));
        var trabalhador = mapper.toTrabalhadorEntity(request);
        addPerfilTrabalhador(trabalhador);
        trabalhador = repository.save(trabalhador);
        return mapper.toTrabalhadorResponse(trabalhador);
    }

    private void addPerfilTrabalhador(TrabalhadorEntity trabalhador) {
        trabalhador.getPerfis().add(new PerfilEntity(idPerfilTrabalhador));
    }

    public List<TrabalhadorResponse> findAll() {
        return repository.findAll().stream()
                .map(mapper::toTrabalhadorResponse)
                .collect(Collectors.toList());
    }

    public Optional<TrabalhadorResponse> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toTrabalhadorResponse);
    }

    public Optional<TrabalhadorResponse> update(Long id, TrabalhadorRequest request) {
        Optional<TrabalhadorEntity> trabalhador = repository.findById(id);
        if (trabalhador.isEmpty()) {
            return Optional.empty();
        }
        setTrabalhador(trabalhador.get(), request);
        return Optional.of(mapper.toTrabalhadorResponse(repository.save(trabalhador.get())));
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

    private void setTrabalhador(TrabalhadorEntity entity, TrabalhadorRequest request) {
        entity.setDescricao(request.getDescricao());
        entity.setNome(request.getNome());
    }
}
