package me.gabu.gabazar.editoras.core.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.gabu.gabazar.editoras.service.validations.CreateValidation;
import me.gabu.gabazar.editoras.service.validations.UpdateValidation;

@Getter
@Setter
@ToString
public class Editora {
    private @NotNull(groups = UpdateValidation.class) String id;
    private @NotNull(groups = { UpdateValidation.class, CreateValidation.class }) String nome;
    private @NotNull(groups = { UpdateValidation.class, CreateValidation.class }) String cnpj;
    private @NotNull(groups = { UpdateValidation.class, CreateValidation.class }) String site;
    private Date dataCriacao;
    private Date dataAlteracao;
    private String usuarioCriacao;
    private String usuarioAlteracao;
}
