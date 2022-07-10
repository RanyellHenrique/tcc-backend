package br.com.unip.tcc.services;

import br.com.unip.tcc.dtos.requests.OfertaRequest;
import br.com.unip.tcc.dtos.responses.OfertaResponse;
import br.com.unip.tcc.entities.ClienteEntity;
import br.com.unip.tcc.entities.OfertaEntity;
import br.com.unip.tcc.mappers.OfertaMapper;
import br.com.unip.tcc.repositories.ClienteRepository;
import br.com.unip.tcc.repositories.OfertaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OfertaService {

    private final OfertaMapper mapper;
    private final OfertaRepository repository;
    private final ClienteRepository clienteRepository;

    public OfertaResponse insert(OfertaRequest request, String emailCliente) {
        var oferta = mapper.toOfertaEntity(request);
        setClienteInOferta(oferta, emailCliente);
        repository.save(oferta);
        return mapper.toOfertaResponse(oferta);
    }

    public Page<OfertaResponse> findAllPage(Long categoria, String titulo, Pageable pageable) {
        return repository.findAllPage(getCategoria(categoria), titulo, pageable)
                .map(mapper::toOfertaResponse);
    }

    private Long getCategoria(Long categoria) {
        return categoria == 0 ? null : categoria;
    }

    public Optional<OfertaResponse> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toOfertaResponse);
    }

    public Optional<OfertaResponse> update(Long id, OfertaRequest request) {
        Optional<OfertaEntity> Oferta = repository.findById(id);
        if (Oferta.isEmpty()) {
            return Optional.empty();
        }
        setOferta(Oferta.get(), request);
        return Optional.of(mapper.toOfertaResponse(repository.save(Oferta.get())));
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

    private void setOferta(OfertaEntity entity, OfertaRequest request) {
        entity.setDescricao(request.getDescricao());
    }

    private void setClienteInOferta(OfertaEntity oferta, String emailCliente) {
        ClienteEntity cliente = clienteRepository.findByEmail(emailCliente);
        oferta.setCliente(cliente);
    }
}
