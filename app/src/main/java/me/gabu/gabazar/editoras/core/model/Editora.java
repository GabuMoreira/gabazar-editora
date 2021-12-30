package me.gabu.gabazar.editoras.core.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Editora {
    private String id;
    private String nome;
    private String site;
    private Date dataCriacao;
    private Date dataAlteracao;
    private String usuario;
}
