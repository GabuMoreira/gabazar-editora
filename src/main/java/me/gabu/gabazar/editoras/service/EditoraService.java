
package me.gabu.gabazar.editoras.service;

import me.gabu.gabazar.editoras.core.model.Editora;

public interface EditoraService {

    public Editora criarEditora(Editora editora);
    public Editora atualizarEditora(Editora editora);
    public Editora buscar(Editora exemplo);
    public void apagar(String editoraId);

}
