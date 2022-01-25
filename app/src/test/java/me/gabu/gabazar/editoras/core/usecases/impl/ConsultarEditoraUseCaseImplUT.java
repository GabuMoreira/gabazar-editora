package me.gabu.gabazar.editoras.core.usecases.impl;

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

@ExtendWith(MockitoExtension.class)
class ConsultarEditoraUseCaseImplUT {

    private static final String ID = UUID.randomUUID().toString();

    private @Mock EditoraDAO dao;
    private @InjectMocks ConsultarEditoraUseCaseImpl uc;

    private Editora model = Editora.builder().build();

    @AfterEach
    public void afterEach() {
        verifyNoMoreInteractions(dao);
    }

    @Test
    void test() {
        doReturn(model).when(dao).findById(ID);

        uc.run(ID);

        verify(dao, times(1)).findById(ID);
    }

}
