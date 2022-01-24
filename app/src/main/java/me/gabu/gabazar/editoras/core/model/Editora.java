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

    private static final String MSG_NULO = "não deve ser nulo";

    private @NotNull(groups = Update.class, message = MSG_NULO) String id;
    private @NotNull(groups = { Update.class, Create.class }, message = MSG_NULO) String nome;
    private @NotNull(groups = { Update.class, Create.class }, message = MSG_NULO) String cnpj;
    private @NotNull(groups = { Update.class, Create.class }, message = MSG_NULO) String site;
    private Date dataCriacao;
    private Date dataAlteracao;
    private String usuarioCriacao;
    private String usuarioAlteracao;
}
