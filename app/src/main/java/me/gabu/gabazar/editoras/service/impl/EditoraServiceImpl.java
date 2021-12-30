package me.gabu.gabazar.editoras.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import me.gabu.gabazar.editoras.core.model.Editora;
import me.gabu.gabazar.editoras.core.usecases.CriarEditoraUseCase;
import me.gabu.gabazar.editoras.service.EditoraService;

@Slf4j
@Service
public class EditoraServiceImpl implements EditoraService {

    @Autowired
    private CriarEditoraUseCase salvarEditora;

    @Override
    public Editora criarEditora(Editora editora, String usuario) {
        log.info("Usuario {} solicitou criação da editora: {}", usuario, editora);
        return salvarEditora.run(editora, usuario);
    }

    @Override
    public Editora atualizarEditora(Editora editora) {
        return editora;
    }

    @Override
    public List<Editora> listarEditoras() {
        return Collections.emptyList();
    }

    @Override
    public List<Editora> buscarEditoras(Editora exemplo) {
        return Collections.emptyList();
    }

    @Override
    public void apagarEditora(String editoraId) {

    }

}
