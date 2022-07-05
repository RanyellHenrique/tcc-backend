package br.com.unip.tcc.entities;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tb_trabalhador")
@JsonTypeName("tb_trabalhador")
@SequenceGenerator(name = "seq_tb_usuarios", sequenceName = "seq_tb_trabalhador", allocationSize = 1)
public class TrabalhadorEntity extends UsuarioEntity {

    private String cpf;

    @ManyToMany
    @JoinTable(
            name = "tb_trabalhador_categoria",
            joinColumns = @JoinColumn(name = "trabalhador_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<CategoriaEntity> categorias = new ArrayList<>();

}
