package me.gabu.gabazar.editoras.core.usecases;

import me.gabu.gabazar.editoras.core.model.Editora;

public interface AtualizarEditoraUseCase {
    Editora run(Editora editora, String usuario);
}
