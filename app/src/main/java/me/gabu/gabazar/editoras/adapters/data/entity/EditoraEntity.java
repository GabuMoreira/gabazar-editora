package me.gabu.gabazar.editoras.adapters.data.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class EditoraEntity {

    @Id
    private String id;
    private String nome;
    private String site;
    private Date dataCriacao;
    private Date dataAlteracao;
    private String usuario;

}
