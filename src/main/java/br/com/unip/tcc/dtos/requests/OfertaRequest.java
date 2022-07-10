package br.com.unip.tcc.dtos.requests;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OfertaRequest {

    private String titulo;
    private String subTitulo;
    private String descricao;
    private BigDecimal preco;
    private Boolean ativa;
    private EnderecoRequest endereco;
    private List<CategoriaRequest> categorias;

}
