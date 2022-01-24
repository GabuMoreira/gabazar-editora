package me.gabu.gabazar.editoras.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import me.gabu.gabazar.editoras.core.exceptions.BadRequestException;
import me.gabu.gabazar.editoras.core.model.Editora;
import me.gabu.gabazar.editoras.service.validations.ValidationEnum;

@ExtendWith(SpringExtension.class)
class ValidationServiceImplTest {

    private static final String ID = "ID";
    private static final String ERRO_CNPJ_NULO = "[cnpj não deve ser nulo]";
    private static final String ERRO_SITE_NULO = "[site não deve ser nulo]";
    private static final String ERRO_NOME_NULO = "[nome não deve ser nulo]";
    private static final String ERRO_ID_NULO = "[id não deve ser nulo]";

    private static final String SITE = "www.google.com";
    private static final String CNPJ = "11.111.111/00001-11";
    private static final String NOME = "nome";

    private @Mock Validator validator;

    private @InjectMocks @Spy ValidationServiceImpl service = new ValidationServiceImpl();

    @BeforeEach
    void beforeEach() {
        when(service.getValidator()).thenReturn(Validation.buildDefaultValidatorFactory().getValidator());
    }

    @Test
    void validateCreateOK() throws Exception {
        Editora autor = Editora.builder().nome(NOME).cnpj(CNPJ).site(SITE).build();
        service.validate(autor, ValidationEnum.CREATE);
    }

    @Test
    void validateCreateBadRequest() throws Exception {
        Editora autor = Editora.builder().build();

        BadRequestException assertThrows = assertThrows(BadRequestException.class, () -> {
            service.validate(autor, ValidationEnum.CREATE);
        });

        List<String> errosEsperados = Arrays.asList(ERRO_NOME_NULO, ERRO_CNPJ_NULO, ERRO_SITE_NULO);
        List<String> errosRetornados = new ArrayList<>(assertThrows.getMessages());

        Collections.sort(errosEsperados);
        Collections.sort(errosRetornados);

        assertEquals(3, errosRetornados.size());
        assertEquals(errosEsperados, errosRetornados);
    }

    @Test
    void validateUpdateOK() throws Exception {
        Editora autor = Editora.builder().id(ID).nome(NOME).cnpj(CNPJ).site(SITE).build();
        service.validate(autor, ValidationEnum.UPDATE);
    }

    @Test
    void validateUpdateBadRequest() throws Exception {
        Editora autor = Editora.builder().build();

        BadRequestException assertThrows = assertThrows(BadRequestException.class, () -> {
            service.validate(autor, ValidationEnum.UPDATE);
        });

        List<String> errosEsperados = Arrays.asList(ERRO_ID_NULO, ERRO_CNPJ_NULO, ERRO_SITE_NULO, ERRO_NOME_NULO);
        List<String> errosRetornados = new ArrayList<>(assertThrows.getMessages());

        Collections.sort(errosEsperados);
        Collections.sort(errosRetornados);

        assertEquals(4, errosRetornados.size());
        assertEquals(errosEsperados, errosRetornados);
    }

}
