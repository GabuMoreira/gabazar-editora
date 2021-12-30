package me.gabu.gabazar.editoras.core.usecases.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import me.gabu.gabazar.editoras.adapters.data.dao.EditoraDAO;
import me.gabu.gabazar.editoras.core.exceptions.UsuarioException;
import me.gabu.gabazar.editoras.core.model.Editora;
import me.gabu.gabazar.editoras.core.usecases.CriarEditoraUseCase;
import me.gabu.gabazar.editoras.service.UsuarioService;

@Slf4j
@Service
public class CriarEditoraUseCaseImpl implements CriarEditoraUseCase {

    @Autowired
    private EditoraDAO dao;
    @Autowired
    private UsuarioService usuarioService;

    @Override
    public Editora run(Editora editora, String usuario) {
        log.info("Iniciando caso de uso de criação de editora para: {}", editora);
        if (!isUsuarioAtivo(usuario)) {
            throw new UsuarioException("Usuario inativo não pode cadastrar novas editoras");
        }
        editora.setUsuarioCriacao(usuario);
        return dao.save(editora);
    }

    private boolean isUsuarioAtivo(String usuario) {
        return usuarioService.isUsuarioAtivo(usuario);
    }

}
