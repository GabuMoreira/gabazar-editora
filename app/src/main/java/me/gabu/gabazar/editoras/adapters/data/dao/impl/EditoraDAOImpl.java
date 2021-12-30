package me.gabu.gabazar.editoras.adapters.data.dao.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;
import me.gabu.gabazar.editoras.adapters.data.dao.EditoraDAO;
import me.gabu.gabazar.editoras.adapters.data.entity.EditoraEntity;
import me.gabu.gabazar.editoras.adapters.data.entity.mapper.EditoraEntityMapper;
import me.gabu.gabazar.editoras.adapters.data.repository.EditoraRepository;
import me.gabu.gabazar.editoras.core.model.Editora;

@Service
@NoArgsConstructor
public class EditoraDAOImpl implements EditoraDAO {

    @Autowired
    private EditoraRepository repository;
    private EditoraEntityMapper mapper = EditoraEntityMapper.INSTANCE;

    @Override
    public Editora save(Editora editora) {
        EditoraEntity enditoraEntity = mapper.editoraToEditoraEntity(editora);

        return mapper.editoraEntityToEditora(repository.save(enditoraEntity));
    }

    @Override
    public List<Editora> listAll() {
        return Collections.emptyList();
    }

    @Override
    public List<Editora> findByExample(Editora editora) {
        return Collections.emptyList();
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
