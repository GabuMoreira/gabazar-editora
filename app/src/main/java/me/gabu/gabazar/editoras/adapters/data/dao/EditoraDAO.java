package me.gabu.gabazar.editoras.adapters.data.dao;

import java.util.Collection;

import me.gabu.gabazar.editoras.core.model.Editora;

public interface EditoraDAO {

    public Editora findById(String id);
    public Editora save(Editora editora);
    public Collection<Editora> listAll();
    public Collection<Editora> findByNome(String name);
    public Editora update(Editora editora);
    public String delete(Editora editora);
}
