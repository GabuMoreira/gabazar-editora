package me.gabu.gabazar.editoras.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.gabu.gabazar.editoras.core.model.Editora;
import me.gabu.gabazar.editoras.core.usecases.SalvarEditoraUseCase;
import me.gabu.gabazar.editoras.service.EditoraService;

@Service
public class EditoraServiceImpl implements EditoraService {

    @Autowired
    private SalvarEditoraUseCase salvarEditora;

    @Override
    public Editora criarEditora(Editora editora) {
        return salvarEditora.run(editora);
    }

    @Override
    public Editora atualizarEditora(Editora editora) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Editora> listarEditoras() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Editora> buscarEditoras(Editora exemplo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void apagarEditora(String editoraId) {
        // TODO Auto-generated method stub

    }

}
