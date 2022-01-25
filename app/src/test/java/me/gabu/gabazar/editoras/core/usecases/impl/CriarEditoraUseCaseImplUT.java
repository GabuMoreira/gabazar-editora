package me.gabu.gabazar.editoras.core.usecases.impl;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import me.gabu.gabazar.editoras.adapters.data.dao.EditoraDAO;
import me.gabu.gabazar.editoras.core.model.Editora;
import me.gabu.gabazar.editoras.service.ValidationService;
import me.gabu.gabazar.editoras.service.validations.ValidationEnum;

@ExtendWith(MockitoExtension.class)
class CriarEditoraUseCaseImplUT {

    private static final String USUARIO = "Johnny";

    private @Mock EditoraDAO dao;
    private @Mock ValidationService validation;
    private @InjectMocks CriarEditoraUseCaseImpl uc;

    private Editora model = Editora.builder().build();

    @AfterEach
    public void afterEach() {
        verifyNoMoreInteractions(dao);
        verifyNoMoreInteractions(validation);
    }

    @Test
    void run() {
        when(dao.save(model)).thenReturn(model);
        doNothing().when(validation).validate(model, ValidationEnum.CREATE);

        uc.run(model, USUARIO);

        verify(dao, times(1)).save(model);
        verify(validation, times(1)).validate(model, ValidationEnum.CREATE);
    }

}
