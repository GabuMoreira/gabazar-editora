package me.gabu.gabazar.editoras.core.usecases.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.gabu.gabazar.editoras.adapters.data.dao.EditoraDAO;
import me.gabu.gabazar.editoras.core.model.Editora;
import me.gabu.gabazar.editoras.core.usecases.SalvarEditoraUseCase;

@Service
public class SalvarEditoraUseCaseImpl implements SalvarEditoraUseCase {

    @Autowired
    private EditoraDAO dao;

    @Override
    public Editora run(Editora editora) {
        return dao.save(editora);
    }

}
