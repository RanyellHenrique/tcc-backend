package br.com.unip.tcc.mappers;

import br.com.unip.tcc.dtos.requests.CategoriaRequest;
import br.com.unip.tcc.dtos.responses.CategoriaResponse;
import br.com.unip.tcc.entities.CategoriaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    CategoriaEntity toCategoriaEntity(CategoriaRequest categoriaRequest);

    CategoriaResponse toCategoriaResponse(CategoriaEntity categoriaEntity);
}
