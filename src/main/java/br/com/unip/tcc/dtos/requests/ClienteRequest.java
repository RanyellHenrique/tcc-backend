package br.com.unip.tcc.dtos.requests;

import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotBlank;

@Data
public class ClienteRequest extends UsuarioRequest {

    @CNPJ
    @NotBlank
    private String cnpj;
}
