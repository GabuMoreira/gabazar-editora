package me.gabu.gabazar.editoras.adapters.data.dao;

import java.util.List;

import me.gabu.gabazar.editoras.core.model.Editora;

public interface EditoraDAO {

    public Editora save(Editora editora);
    public List<Editora> listAll();
    public List<Editora> findByExample(Editora editora);
    public Editora update(Editora editora);
    public String delete(String editoraId);
}
