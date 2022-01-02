package me.gabu.gabazar.editoras.core.usecases.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;
import me.gabu.gabazar.editoras.adapters.data.dao.EditoraDAO;
import me.gabu.gabazar.editoras.core.exceptions.BadRequestException;
import me.gabu.gabazar.editoras.core.model.Editora;
import me.gabu.gabazar.editoras.core.usecases.AtualizarEditoraUseCase;
import me.gabu.gabazar.editoras.core.usecases.ConsultarEditoraUseCase;

@Slf4j
@Service
public class AtualizarEditoraUseCaseImpl implements AtualizarEditoraUseCase {

    private @Autowired EditoraDAO dao;
    private @Autowired ConsultarEditoraUseCase consultarUC;

    @Override
    public Editora run(Editora editora, String usuario) {
        Editora registroAnterior = consultarUC.run(editora.getId());

        log.info("[USECASE] [UPDATE]\nRegistro anterior: {} \nRegistro recebido:{}", registroAnterior, editora);

        if (!StringUtils.hasLength(editora.getNome()))
            throw new BadRequestException("Campo nome não pode estar vazio!");

        if (!StringUtils.hasLength(editora.getCnpj()))
            throw new BadRequestException("Campo cnpj não pode estar vazio!");

        if (!StringUtils.hasLength(editora.getSite()))
            throw new BadRequestException("Campo site não pode estar vazio!");

        editora.setUsuarioAlteracao(usuario);
        editora.setUsuarioCriacao(registroAnterior.getUsuarioCriacao());
        editora.setDataCriacao(registroAnterior.getDataCriacao());

        return dao.update(editora);
    }

}
