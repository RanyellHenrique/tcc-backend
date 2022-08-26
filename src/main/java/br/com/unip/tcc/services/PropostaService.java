package br.com.unip.tcc.services;

import br.com.unip.tcc.dtos.requests.PropostaAnaliseRequest;
import br.com.unip.tcc.dtos.requests.PropostaRequest;
import br.com.unip.tcc.dtos.responses.PropostaResponse;
import br.com.unip.tcc.entities.OfertaEntity;
import br.com.unip.tcc.entities.PropostaEntity;
import br.com.unip.tcc.entities.TrabalhadorEntity;
import br.com.unip.tcc.entities.pk.PropostaEntityPK;
import br.com.unip.tcc.mappers.PropostaMapper;
import br.com.unip.tcc.repositories.ClienteRepository;
import br.com.unip.tcc.repositories.OfertaRepository;
import br.com.unip.tcc.repositories.PropostaRepository;
import br.com.unip.tcc.repositories.TrabalhadorRepository;
import br.com.unip.tcc.services.exceptions.ForbiddenException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static br.com.unip.tcc.entities.enums.EstadoPropostaEnum.ABERTA;

@Service
@RequiredArgsConstructor
public class PropostaService {

    private final PropostaRepository repository;
    private final TrabalhadorRepository trabalhadorRepository;
    private final ClienteRepository clienteRepository;
    private final OfertaRepository ofertaRepository;
    private final PropostaMapper mapper;

    public PropostaResponse insert(PropostaRequest request, String emailTrabalhador) {
        var trabalhador = trabalhadorRepository.findByEmail(emailTrabalhador);
        var oferta = ofertaRepository.findOfertaById(request.getIdOferta());
        var proposta = mapper.toPropostaEntity(request);
        setInsertPropostaEntity(proposta, trabalhador, oferta);
        proposta = repository.save(proposta);
        return mapper.toPropostaResponse(proposta);
    }

    private void setInsertPropostaEntity(PropostaEntity proposta, TrabalhadorEntity trabalhador, OfertaEntity oferta) {
        proposta.setPropostaPK(new PropostaEntityPK());
        proposta.getPropostaPK().setTrabalhador(trabalhador);
        proposta.getPropostaPK().setOferta(oferta);
        proposta.setEstado(ABERTA);
    }

    public Page<PropostaResponse> findByCliente(String clienteEmail, Long ofertaId, PageRequest pageRequest) {
        var cliente = clienteRepository.findByEmail(clienteEmail);
        return repository.findAllPropostasByCliente(cliente.getId(), ofertaId, pageRequest)
                .map(mapper::toPropostaResponse);
    }

    public Page<PropostaResponse> findByTrabalhador(String clienteEmail, Long ofertaId, PageRequest pageRequest) {
        var trabalhador = trabalhadorRepository.findByEmail(clienteEmail);
        return repository.findAllPropostasByTrabalhador(trabalhador.getId(), ofertaId, pageRequest)
                .map(mapper::toPropostaResponse);
    }

    public Optional<PropostaEntity> evalueteProposta(PropostaAnaliseRequest request, String clienteEmail) {
        var oferta = ofertaRepository.findById(request.getIdOferta()).orElseThrow();
        if(!clienteEmail.equals(oferta.getCliente().getEmail())) {
            throw new ForbiddenException("Forbidden");
        }
        var trabalhador = trabalhadorRepository.findById(request.getIdTrabalhador()).orElseThrow();
        Optional<PropostaEntity> proposta = repository.findById(new PropostaEntityPK(trabalhador, oferta));
        setEvalueteProposta(proposta, request);
        return proposta;
    }

    public Optional<PropostaEntity> evaluetePropostaById(PropostaAnaliseRequest request, String clienteEmail, Long id) {
        var oferta = ofertaRepository.findById(request.getIdOferta()).orElseThrow();
        if(!clienteEmail.equals(oferta.getCliente().getEmail())) {
            throw new ForbiddenException("Forbidden");
        }
        var trabalhador = trabalhadorRepository.findById(request.getIdTrabalhador()).orElseThrow();
        Optional<PropostaEntity> proposta = repository.findByIdProposta(id);
        setEvalueteProposta(proposta, request);
        return proposta;
    }

    private void setEvalueteProposta(Optional<PropostaEntity> proposta, PropostaAnaliseRequest request) {
        if(proposta.isPresent()) {
            PropostaEntity propostaEntity = proposta.get();
            propostaEntity.setEstado(request.getEstado());
            propostaEntity.setAnaliseDescricao(request.getAnaliseDescricao());
            propostaEntity.getPropostaPK().getOferta().setAtiva(false);
            repository.save(proposta.get());
        }
    }

    public PropostaResponse findById(String email, Long id) {
        Optional<PropostaEntity> proposta = repository.findByIdProposta(id);

        if(proposta.isPresent()) {
            if (userIsPartProposta(proposta.get(), email)) {
                return mapper.toPropostaResponse(proposta.get());
            }
            throw new ForbiddenException("Forbidden");
        } else {
            throw new IllegalArgumentException("Erro ao realizar a pesquisa");
        }
    }

    private boolean userIsPartProposta(PropostaEntity proposta, String email) {
        return email.equals(proposta.getPropostaPK().getTrabalhador().getEmail()) ||
                email.equals(proposta.getPropostaPK().getOferta().getCliente().getEmail());
    }
}
