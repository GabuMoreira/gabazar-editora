package me.gabu.gabazar.editoras.adapters.html.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    private String usuarioCriacao;
    private String usuarioAlteracao;
    private @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") Date dataCriacao;
    private @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") Date dataAlteracao;

}
