package me.gabu.gabazar.editoras.core.usecases.impl;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import me.gabu.gabazar.editoras.adapters.data.dao.EditoraDAO;
import me.gabu.gabazar.editoras.core.model.Editora;
import me.gabu.gabazar.editoras.core.usecases.SalvarEditoraUseCase;

@Component
@AllArgsConstructor
public class SalvarEditoraUseCaseImpl implements SalvarEditoraUseCase {

    private static EditoraDAO dao;

    @Override
    public Editora run(Editora editora) {
        return dao.save(editora);
    }

}
