package br.com.unip.tcc.mappers;

import br.com.unip.tcc.dtos.requests.UsuarioRequest;
import br.com.unip.tcc.dtos.responses.UsuarioResponse;
import br.com.unip.tcc.entities.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioEntity toUsuarioEntity(UsuarioRequest request);

    UsuarioResponse toUsuarioResponse(UsuarioEntity entity);
}
