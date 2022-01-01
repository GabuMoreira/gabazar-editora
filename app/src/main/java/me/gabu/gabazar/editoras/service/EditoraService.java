
package me.gabu.gabazar.editoras.service;

import java.util.Collection;

import me.gabu.gabazar.editoras.core.model.Editora;

public interface EditoraService {

    public Editora criarEditora(Editora editora, String usuario);

    public Editora consultaEditora(String editoraId);

    public Editora atualizarEditora(Editora editora, String usuario);

    public Collection<Editora> buscarEditoras(String nome);

    public void apagarEditora(String editoraId);

}
