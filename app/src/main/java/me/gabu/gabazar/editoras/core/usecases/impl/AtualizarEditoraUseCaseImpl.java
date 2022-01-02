package me.gabu.gabazar.editoras.core.usecases.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import me.gabu.gabazar.editoras.adapters.data.dao.EditoraDAO;
import me.gabu.gabazar.editoras.core.model.Editora;
import me.gabu.gabazar.editoras.core.usecases.AtualizarEditoraUseCase;
import me.gabu.gabazar.editoras.core.usecases.ConsultarEditoraUseCase;
import me.gabu.gabazar.editoras.service.ValidationService;
import me.gabu.gabazar.editoras.service.validations.ValidationEnum;

@Slf4j
@Service
public class AtualizarEditoraUseCaseImpl implements AtualizarEditoraUseCase {

    private @Autowired EditoraDAO dao;
    private @Autowired ConsultarEditoraUseCase consultarUC;
    private @Autowired ValidationService validator;

    @Override
    public Editora run(Editora editora, String usuario) {
        Editora registroAnterior = consultarUC.run(editora.getId());

        validator.validate(editora, ValidationEnum.UPDATE);
        log.info("[USECASE] [UPDATE]\nRegistro anterior: {} \nRegistro recebido:{}", registroAnterior, editora);

        editora.setUsuarioAlteracao(usuario);
        editora.setUsuarioCriacao(registroAnterior.getUsuarioCriacao());
        editora.setDataCriacao(registroAnterior.getDataCriacao());

        return dao.update(editora);
    }

}
