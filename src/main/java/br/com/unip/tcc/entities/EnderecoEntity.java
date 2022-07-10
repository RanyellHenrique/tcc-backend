package br.com.unip.tcc.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_endereco")
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
}
