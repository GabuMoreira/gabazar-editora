
package me.gabu.gabazar.editoras.service;

import java.util.Collection;

import me.gabu.gabazar.editoras.core.model.Editora;

public interface EditoraService {

    public Editora criarEditora(Editora editora, String usuario);

    public Editora consultarEditora(String editoraId);

    public Editora atualizarEditora(Editora editora, String usuario);

    public Collection<Editora> listarEditoras(String nome);

    public void apagarEditora(String editoraId, String usuario);

}
