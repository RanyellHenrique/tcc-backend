package br.com.unip.tcc.mappers;

import br.com.unip.tcc.dtos.requests.TrabalhadorRequest;
import br.com.unip.tcc.dtos.responses.TrabalhadorResponse;
import br.com.unip.tcc.entities.TrabalhadorEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrabalhadorMapper {

    TrabalhadorEntity toTrabalhadorEntity(TrabalhadorRequest request);

    TrabalhadorResponse toTrabalhadorResponse(TrabalhadorEntity entity);
}
