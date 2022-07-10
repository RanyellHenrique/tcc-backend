package br.com.unip.tcc.mappers;

import br.com.unip.tcc.dtos.requests.OfertaRequest;
import br.com.unip.tcc.dtos.responses.OfertaResponse;
import br.com.unip.tcc.entities.OfertaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OfertaMapper {

    OfertaEntity toOfertaEntity(OfertaRequest request);

    OfertaResponse toOfertaResponse(OfertaEntity entity);
}
