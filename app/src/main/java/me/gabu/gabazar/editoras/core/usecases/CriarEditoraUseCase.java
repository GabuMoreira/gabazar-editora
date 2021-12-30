package me.gabu.gabazar.editoras.core.usecases;

import me.gabu.gabazar.editoras.core.model.Editora;

public interface CriarEditoraUseCase {
    Editora run(Editora editora, String usuario);
}
