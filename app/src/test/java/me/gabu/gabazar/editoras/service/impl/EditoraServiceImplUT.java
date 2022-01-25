package me.gabu.gabazar.editoras.service.impl;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import me.gabu.gabazar.editoras.core.model.Editora;
import me.gabu.gabazar.editoras.core.usecases.ApagarEditoraUseCase;
import me.gabu.gabazar.editoras.core.usecases.AtualizarEditoraUseCase;
import me.gabu.gabazar.editoras.core.usecases.ConsultarEditoraUseCase;
import me.gabu.gabazar.editoras.core.usecases.CriarEditoraUseCase;
import me.gabu.gabazar.editoras.core.usecases.ListarEditorasUseCase;

@ExtendWith(MockitoExtension.class)
class EditoraServiceImplUT {

    private static final String ID = UUID.randomUUID().toString();
    private static final String USUARIO = "Johnny";
    private static final String NOME = "nome";

    private @Mock CriarEditoraUseCase criarUC;
    private @Mock ConsultarEditoraUseCase consultarUC;
    private @Mock AtualizarEditoraUseCase atualizarUC;
    private @Mock ListarEditorasUseCase listarUC;
    private @Mock ApagarEditoraUseCase apagarUC;
    private @InjectMocks EditoraServiceImpl service;

    private Editora model = Editora.builder().build();

    @Test
    void criarEditora() {
        doReturn(model).when(criarUC).run(model, USUARIO);
        service.criarEditora(model, USUARIO);
        verify(criarUC, times(1)).run(model, USUARIO);
    }

    @Test
    void consultarEditora() {
        doReturn(model).when(consultarUC).run(ID);
        service.consultarEditora(ID);
        verify(consultarUC, times(1)).run(ID);
    }

    @Test
    void atualizarEditora() {
        doReturn(model).when(atualizarUC).run(model, USUARIO);
        service.atualizarEditora(model, USUARIO);
        verify(atualizarUC, times(1)).run(model, USUARIO);
    }

    @Test
    void listarEditoraes() {
        doReturn(Arrays.asList(model)).when(listarUC).run(NOME);
        service.listarEditoras(NOME);
        verify(listarUC, times(1)).run(NOME);
    }

    @Test
    void apagarEditora() {
        doNothing().when(apagarUC).run(ID, USUARIO);
        service.apagarEditora(ID, USUARIO);
        verify(apagarUC, times(1)).run(ID, USUARIO);
    }
}
