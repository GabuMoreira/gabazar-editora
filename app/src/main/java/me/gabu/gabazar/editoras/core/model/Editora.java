package me.gabu.gabazar.editoras.core.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.gabu.gabazar.editoras.service.validations.Create;
import me.gabu.gabazar.editoras.service.validations.Update;

@Getter
@Setter
@Builder
@ToString
public class Editora {
    private @NotNull(groups = Update.class) String id;
    private @NotNull(groups = { Update.class, Create.class }) String nome;
    private @NotNull(groups = { Update.class, Create.class }) String cnpj;
    private @NotNull(groups = { Update.class, Create.class }) String site;
    private Date dataCriacao;
    private Date dataAlteracao;
    private String usuarioCriacao;
    private String usuarioAlteracao;
}
