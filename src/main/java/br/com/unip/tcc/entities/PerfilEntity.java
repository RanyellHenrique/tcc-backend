package br.com.unip.tcc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "tb_perfil")
@AllArgsConstructor
@NoArgsConstructor
public class PerfilEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    public PerfilEntity(Long id) {
        this.id = id;
    }
}
