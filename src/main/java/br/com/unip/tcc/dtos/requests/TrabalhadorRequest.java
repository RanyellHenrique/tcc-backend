package br.com.unip.tcc.dtos.requests;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class TrabalhadorRequest extends UsuarioRequest {

    @CPF
    @NotBlank
    private String cpf;

    @NotEmpty
    @Size(max = 3, min = 1)
    private List<CategoriaRequest> categorias;
}
