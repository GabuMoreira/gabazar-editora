package me.gabu.gabazar.editoras.core.usecases;

import me.gabu.gabazar.editoras.core.model.Editora;

public interface ConsultarEditoraUseCase {
    Editora run(String editoraId);
}
