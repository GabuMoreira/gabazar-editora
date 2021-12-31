package me.gabu.gabazar.editoras.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import me.gabu.gabazar.editoras.core.model.Editora;
import me.gabu.gabazar.editoras.core.usecases.CriarEditoraUseCase;
import me.gabu.gabazar.editoras.core.usecases.ListarEditorasUseCase;
import me.gabu.gabazar.editoras.service.EditoraService;

@Slf4j
@Service
public class EditoraServiceImpl implements EditoraService {

    private @Autowired CriarEditoraUseCase salvarEditora;
    private @Autowired ListarEditorasUseCase listarEditoras;

    @Override
    public Editora criarEditora(Editora editora, String usuario) {
        log.info("[SERVICE] [CREATE] [Usuario: {}]  {}", usuario, editora);
        return salvarEditora.run(editora, usuario);
    }

    @Override
    public Editora atualizarEditora(Editora editora) {
        return editora;
    }

    @Override
    public Collection<Editora> buscarEditoras(String nome) {
        return listarEditoras.run(nome);
    }

    @Override
    public void apagarEditora(String editoraId) {

    }

}
