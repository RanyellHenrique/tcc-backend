package br.com.unip.tcc.mappers;

import br.com.unip.tcc.dtos.requests.PropostaRequest;
import br.com.unip.tcc.dtos.responses.PropostaResponse;
import br.com.unip.tcc.entities.PropostaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PropostaMapper {

    PropostaEntity toPropostaEntity(PropostaRequest request);

    @Mapping(source = "entity.propostaPK.trabalhador", target = "trabalhador")
    @Mapping(source = "entity.propostaPK.oferta", target = "oferta")
    PropostaResponse toPropostaResponse(PropostaEntity entity);
}
