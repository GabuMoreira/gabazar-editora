package me.gabu.gabazar.editoras.core.usecases.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import me.gabu.gabazar.editoras.adapters.data.dao.EditoraDAO;
import me.gabu.gabazar.editoras.core.model.Editora;
import me.gabu.gabazar.editoras.core.usecases.ListarEditorasUseCase;

@Service
public class ListarEditoraUseCaseImpl implements ListarEditorasUseCase {

    private @Autowired EditoraDAO dao;

    @Override
    public Collection<Editora> run(String nome) {

        if (StringUtils.hasLength(nome))
            return dao.findByNome(nome);

        return dao.listAll();
    }

}
