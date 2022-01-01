package me.gabu.gabazar.editoras.core.usecases.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.gabu.gabazar.editoras.adapters.data.dao.EditoraDAO;
import me.gabu.gabazar.editoras.core.model.Editora;
import me.gabu.gabazar.editoras.core.usecases.ConsultarEditoraUseCase;

@Service
public class ConsultarEditoraUseCaseImpl implements ConsultarEditoraUseCase {

    private @Autowired EditoraDAO dao;

    @Override
    public Editora run(String editoraId) {
        return dao.findById(editoraId);
    }

}
