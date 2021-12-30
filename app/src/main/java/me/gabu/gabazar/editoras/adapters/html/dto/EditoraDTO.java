package me.gabu.gabazar.editoras.adapters.html.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EditoraDTO {

    private String id;
    private String nome;
    private String cnpj;
    private String site;
    private Date dataCriacao;
    private Date dataAlteracao;
    private String usuarioCriacao;
    private String usuarioAlteracao;

}
