package me.gabu.gabazar.editoras.core.usecases.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import me.gabu.gabazar.editoras.adapters.data.dao.EditoraDAO;
import me.gabu.gabazar.editoras.core.model.Editora;
import me.gabu.gabazar.editoras.core.usecases.ApagarEditoraUseCase;
import me.gabu.gabazar.editoras.core.usecases.ConsultarEditoraUseCase;

@Slf4j
@Service
public class ApagarEditoraUseCaseImpl implements ApagarEditoraUseCase {

    private @Autowired EditoraDAO dao;
    private @Autowired ConsultarEditoraUseCase consultarUC;

    @Override
    public void run(String editoraId, String usuario) {
        log.info("[USECASE] [DELETE] {}", editoraId);

        Editora editora = consultarUC.run(editoraId);
        editora.setUsuarioAlteracao(usuario);

        dao.delete(editora);
    }

}
