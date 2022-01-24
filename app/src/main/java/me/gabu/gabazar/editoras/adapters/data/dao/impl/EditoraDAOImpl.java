package me.gabu.gabazar.editoras.adapters.data.dao.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import me.gabu.gabazar.editoras.adapters.data.dao.EditoraDAO;
import me.gabu.gabazar.editoras.adapters.data.entity.EditoraEntity;
import me.gabu.gabazar.editoras.adapters.data.entity.mapper.EditoraEntityMapper;
import me.gabu.gabazar.editoras.adapters.data.repository.EditoraRepository;
import me.gabu.gabazar.editoras.core.exceptions.NotFoundException;
import me.gabu.gabazar.editoras.core.model.Editora;

@Slf4j
@Service
public class EditoraDAOImpl implements EditoraDAO {

    private @Autowired EditoraRepository repository;

    @Override
    public Editora findById(String id) {
        EditoraEntity enditoraEntity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Editora não encontrada"));
        return getMapper().editoraEntityToEditora(enditoraEntity);
    }

    @Override
    public Editora save(Editora editora) {
        EditoraEntity enditoraEntity = getMapper().editoraToEditoraEntity(editora);
        log.info("[DAO] [PERSIST] [{}]", editora);
        return getMapper().editoraEntityToEditora(repository.save(enditoraEntity));
    }

    @Override
    public Collection<Editora> listAll() {
        return getMapper().editoraEntityToEditora(repository.findAll());
    }

    @Override
    public Collection<Editora> findByNome(String name) {
        return getMapper().editoraEntityToEditora(repository.findByNome(name));
    }

    @Override
    public Editora update(Editora editora) {
        EditoraEntity enditoraEntity = getMapper().editoraToEditoraEntity(editora);
        log.info("[DAO] [UPDATE] [{}]", editora);
        return getMapper().editoraEntityToEditora(repository.save(enditoraEntity));
    }

    @Override
    public void delete(Editora editora) {
        repository.deleteById(editora.getId());
    }

    protected EditoraEntityMapper getMapper() {
        return EditoraEntityMapper.INSTANCE;
    }

}
