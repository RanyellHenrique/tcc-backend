package br.com.unip.tcc.services;

import br.com.unip.tcc.dtos.requests.PropostaRequest;
import br.com.unip.tcc.dtos.responses.PropostaResponse;
import br.com.unip.tcc.entities.OfertaEntity;
import br.com.unip.tcc.entities.PropostaEntity;
import br.com.unip.tcc.entities.TrabalhadorEntity;
import br.com.unip.tcc.entities.pk.PropostaEntityPK;
import br.com.unip.tcc.mappers.PropostaMapper;
import br.com.unip.tcc.repositories.OfertaRepository;
import br.com.unip.tcc.repositories.PropostaRepository;
import br.com.unip.tcc.repositories.TrabalhadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static br.com.unip.tcc.entities.enums.EstadoPropostaEnum.ABERTA;

@Service
@RequiredArgsConstructor
public class PropostaService {

    private final PropostaRepository repository;
    private final TrabalhadorRepository trabalhadorRepository;
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
}
