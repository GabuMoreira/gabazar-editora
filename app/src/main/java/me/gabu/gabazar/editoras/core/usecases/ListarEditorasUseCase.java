package me.gabu.gabazar.editoras.core.usecases;

import java.util.Collection;

import me.gabu.gabazar.editoras.core.model.Editora;

public interface ListarEditorasUseCase {
    Collection<Editora> run(String nome);
}
