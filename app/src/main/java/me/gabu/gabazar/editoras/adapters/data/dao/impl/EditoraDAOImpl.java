package me.gabu.gabazar.editoras.adapters.data.dao.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import me.gabu.gabazar.editoras.adapters.data.dao.EditoraDAO;
import me.gabu.gabazar.editoras.adapters.data.entity.EditoraEntity;
import me.gabu.gabazar.editoras.adapters.data.entity.mapper.EditoraEntityMapper;
import me.gabu.gabazar.editoras.adapters.data.repository.EditoraRepository;
import me.gabu.gabazar.editoras.core.exceptions.APIException;
import me.gabu.gabazar.editoras.core.model.Editora;

@Slf4j
@Service
public class EditoraDAOImpl implements EditoraDAO {

    @Autowired
    private EditoraRepository repository;
    private EditoraEntityMapper mapper = EditoraEntityMapper.INSTANCE;

    @Override
    public Editora findById(String id) {
        EditoraEntity enditoraEntity = repository.findById(id)
                .orElseThrow(() -> new APIException("Editora não encontrada"));
        return mapper.editoraEntityToEditora(enditoraEntity);
    }

    @Override
    public Editora save(Editora editora) {
        EditoraEntity enditoraEntity = mapper.editoraToEditoraEntity(editora);
        log.info("[DAO] [PERSIST] [{}]", editora);
        return mapper.editoraEntityToEditora(repository.save(enditoraEntity));
    }

    @Override
    public Collection<Editora> listAll() {
        return mapper.editoraEntityToEditora(repository.findAll());
    }

    @Override
    public Collection<Editora> findByNome(String name) {
        return mapper.editoraEntityToEditora(repository.findByNome(name));
    }

    @Override
    public Editora update(Editora editora) {
        return editora;
    }

    @Override
    public String delete(String editoraId) {
        return null;
    }

}
