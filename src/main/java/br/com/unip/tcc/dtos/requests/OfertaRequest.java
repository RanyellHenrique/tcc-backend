package br.com.unip.tcc.dtos.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Data
public class OfertaRequest {

    @NotBlank
    private String titulo;
    @NotBlank
    private String subTitulo;
    @NotBlank
    private String descricao;
    @NotNull
    private BigDecimal preco;
    private Boolean ativa;
    @NotNull
    private EnderecoRequest endereco;
    @Size(min = 1, max = 3)
    private List<CategoriaRequest> categorias;

}
