package me.gabu.gabazar.editoras.core.usecases.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Date;
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
import me.gabu.gabazar.editoras.service.ValidationService;
import me.gabu.gabazar.editoras.service.validations.ValidationEnum;

@ExtendWith(MockitoExtension.class)
class AtualizarEditoraUseCaseImplTest {

    private static final String ID = UUID.randomUUID().toString();
    private static final String USUARIO = "Johnny";

    private @Mock EditoraDAO dao;
    private @Mock ValidationService validation;
    private @Mock ConsultarEditoraUseCase consultarUC;
    private @InjectMocks AtualizarEditoraUseCaseImpl uc;

    private Editora model = Editora.builder().build();
    private Editora modelRegistroAnterior = Editora.builder().build();

    @AfterEach
    public void afterEach() {
        verifyNoMoreInteractions(dao);
        verifyNoMoreInteractions(validation);
        verifyNoMoreInteractions(consultarUC);
    }

    @Test
    void run() {
        Date dataCriacao = new Date();
        modelRegistroAnterior.setDataCriacao(dataCriacao);
        modelRegistroAnterior.setUsuarioCriacao(USUARIO);

        doReturn(modelRegistroAnterior).when(consultarUC).run(ID);
        doNothing().when(validation).validate(model, ValidationEnum.UPDATE);
        when(dao.update(model)).thenReturn(model);

        model.setId(ID);
        Editora run = uc.run(model, USUARIO);

        assertEquals(dataCriacao, run.getDataCriacao());
        assertEquals(USUARIO, run.getUsuarioCriacao());
        assertEquals(USUARIO, run.getUsuarioAlteracao());

        verify(consultarUC, times(1)).run(ID);
        verify(validation, times(1)).validate(model, ValidationEnum.UPDATE);
        verify(dao, times(1)).update(model);
    }

}
