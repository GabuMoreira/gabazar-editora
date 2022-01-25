package me.gabu.gabazar.editoras.core.usecases.impl;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import me.gabu.gabazar.editoras.adapters.data.dao.EditoraDAO;
import me.gabu.gabazar.editoras.core.model.Editora;
import me.gabu.gabazar.editoras.core.usecases.ConsultarEditoraUseCase;

@ExtendWith(MockitoExtension.class)
class ApagarEditoraUseCaseImplUT {

    private static final String ID = UUID.randomUUID().toString();
    private static final String USUARIO = "Johnny";

    private @Mock EditoraDAO dao;
    private @Mock ConsultarEditoraUseCase consultarUC;
    private @InjectMocks ApagarEditoraUseCaseImpl uc;

    private Editora model = Editora.builder().build();

    @AfterEach
    public void afterEach() {
        verifyNoMoreInteractions(dao);
        verifyNoMoreInteractions(consultarUC);
    }

    @Test
    void run() {
        doReturn(model).when(consultarUC).run(ID);
        doNothing().when(dao).delete(model);

        uc.run(ID, USUARIO);

        verify(consultarUC, times(1)).run(ID);
        verify(dao, times(1)).delete(model);
    }

}
