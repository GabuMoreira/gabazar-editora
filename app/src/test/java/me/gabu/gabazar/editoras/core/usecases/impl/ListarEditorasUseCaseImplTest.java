package me.gabu.gabazar.editoras.core.usecases.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import me.gabu.gabazar.editoras.adapters.data.dao.EditoraDAO;
import me.gabu.gabazar.editoras.core.model.Editora;

@ExtendWith(MockitoExtension.class)
class ListarEditorasUseCaseImplTest {

    private static final String NOME = "NOME";

    private @Mock EditoraDAO dao;
    private @InjectMocks ListarEditorasUseCaseImpl uc;

    private Editora model = Editora.builder().build();

    @AfterEach
    public void afterEach() {
        verifyNoMoreInteractions(dao);
    }

    @Test
    void runListAll() {
        when(dao.listAll()).thenReturn(Arrays.asList(model));

        Collection<Editora> run = uc.run(null);

        assertEquals(1, run.size());
        verify(dao, times(1)).listAll();
    }

    @Test
    void runFindByNome() {
        when(dao.findByNome(NOME)).thenReturn(Arrays.asList(model));

        Collection<Editora> run = uc.run(NOME);

        assertEquals(1, run.size());
        verify(dao, times(1)).findByNome(NOME);
    }

}
