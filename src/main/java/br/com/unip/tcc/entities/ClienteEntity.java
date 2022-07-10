package br.com.unip.tcc.entities;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tb_cliente")
@JsonTypeName("tb_cliente")
@SequenceGenerator(name = "seq_tb_usuarios", sequenceName = "seq_tb_cliente", allocationSize = 1)
public class ClienteEntity extends UsuarioEntity {

    private String cnpj;
}
