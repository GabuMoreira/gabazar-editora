
package me.gabu.gabazar.editoras.service;

import java.util.List;

import me.gabu.gabazar.editoras.core.model.Editora;

public interface EditoraService {

    public Editora criarEditora(Editora editora, String usuario);
    public Editora atualizarEditora(Editora editora);
    public List<Editora> listarEditoras();
    public List<Editora> buscarEditoras(Editora exemplo);
    public void apagarEditora(String editoraId);

}
