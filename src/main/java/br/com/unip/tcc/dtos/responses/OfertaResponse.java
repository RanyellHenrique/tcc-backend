package br.com.unip.tcc.dtos.responses;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OfertaResponse {

    private Long id;
    private String titulo;
    private String subTitulo;
    private String descricao;
    private LocalDateTime dataDeCadastro;
    private LocalDateTime dataDeAtualizacao;
    private BigDecimal preco;
    private Boolean ativa;
    private EnderecoResponse endereco;
    private ClienteResponse cliente;
    private List<CategoriaResponse> categorias;
}
