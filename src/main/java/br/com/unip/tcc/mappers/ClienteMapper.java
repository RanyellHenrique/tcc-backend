package br.com.unip.tcc.mappers;

import br.com.unip.tcc.dtos.requests.ClienteRequest;
import br.com.unip.tcc.dtos.responses.ClienteResponse;
import br.com.unip.tcc.entities.ClienteEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteEntity toClienteEntity(ClienteRequest request);

    ClienteResponse toClienteResponse(ClienteEntity entity);
}
