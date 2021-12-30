package me.gabu.gabazar.editoras.core.usecases;

import me.gabu.gabazar.editoras.core.model.Editora;

public interface ConsultaEditoraUseCase {
    Editora run(String editoraId);
}
