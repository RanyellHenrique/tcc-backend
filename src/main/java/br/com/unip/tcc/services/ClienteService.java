package br.com.unip.tcc.services;

import br.com.unip.tcc.dtos.requests.ClienteRequest;
import br.com.unip.tcc.dtos.responses.ClienteResponse;
import br.com.unip.tcc.entities.ClienteEntity;
import br.com.unip.tcc.mappers.ClienteMapper;
import br.com.unip.tcc.repositories.ClienteRepository;
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
public class ClienteService {

    private final ClienteMapper mapper;
    private final ClienteRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    public ClienteResponse insert(ClienteRequest request) {
        request.setSenha(passwordEncoder.encode(request.getSenha()));
        var Cliente = repository.save(mapper.toClienteEntity(request));
        return mapper.toClienteResponse(Cliente);
    }

    public List<ClienteResponse> findAll() {
        return repository.findAll().stream()
                .map(mapper::toClienteResponse)
                .collect(Collectors.toList());
    }

    public Optional<ClienteResponse> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toClienteResponse);
    }

    public Optional<ClienteResponse> update(Long id, ClienteRequest request) {
        Optional<ClienteEntity> Cliente = repository.findById(id);
        if (Cliente.isEmpty()) {
            return Optional.empty();
        }
        setCliente(Cliente.get(), request);
        return Optional.of(mapper.toClienteResponse(repository.save(Cliente.get())));
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

    private void setCliente(ClienteEntity entity, ClienteRequest request) {
        entity.setDescricao(request.getDescricao());
        entity.setNome(request.getNome());
    }
}
