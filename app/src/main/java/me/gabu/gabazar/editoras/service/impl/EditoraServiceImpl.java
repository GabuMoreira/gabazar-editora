package me.gabu.gabazar.editoras.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.gabu.gabazar.editoras.core.model.Editora;
import me.gabu.gabazar.editoras.core.usecases.ApagarEditoraUseCase;
import me.gabu.gabazar.editoras.core.usecases.AtualizarEditoraUseCase;
import me.gabu.gabazar.editoras.core.usecases.ConsultarEditoraUseCase;
import me.gabu.gabazar.editoras.core.usecases.CriarEditoraUseCase;
import me.gabu.gabazar.editoras.core.usecases.ListarEditorasUseCase;
import me.gabu.gabazar.editoras.service.EditoraService;

@Service
public class EditoraServiceImpl implements EditoraService {

    private @Autowired CriarEditoraUseCase criarEditora;
    private @Autowired ConsultarEditoraUseCase consultarEditora;
    private @Autowired AtualizarEditoraUseCase atualizarEditora;
    private @Autowired ListarEditorasUseCase listarEditoras;
    private @Autowired ApagarEditoraUseCase apagarEditora;

    @Override
    public Editora criarEditora(Editora editora, String usuario) {
        return criarEditora.run(editora, usuario);
    }

    @Override
    public Editora consultarEditora(String editoraId) {
        return consultarEditora.run(editoraId);
    }

    @Override
    public Editora atualizarEditora(Editora editora, String usuario) {
        return atualizarEditora.run(editora, usuario);
    }

    @Override
    public Collection<Editora> listarEditoras(String nome) {
        return listarEditoras.run(nome);
    }

    @Override
    public void apagarEditora(String editoraId, String usuario) {
        apagarEditora.run(editoraId, usuario);
    }

}
