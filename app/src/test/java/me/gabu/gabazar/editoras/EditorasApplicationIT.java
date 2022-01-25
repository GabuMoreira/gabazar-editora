package me.gabu.gabazar.editoras;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import me.gabu.gabazar.editoras.adapters.http.in.EditoraController;
import me.gabu.gabazar.editoras.core.usecases.ApagarEditoraUseCase;
import me.gabu.gabazar.editoras.core.usecases.AtualizarEditoraUseCase;
import me.gabu.gabazar.editoras.core.usecases.ConsultarEditoraUseCase;
import me.gabu.gabazar.editoras.core.usecases.CriarEditoraUseCase;
import me.gabu.gabazar.editoras.core.usecases.ListarEditorasUseCase;
import me.gabu.gabazar.editoras.service.EditoraService;
import me.gabu.gabazar.editoras.service.TokenService;
import me.gabu.gabazar.editoras.service.ValidationService;

@SpringBootTest
@TestPropertySource("classpath:_application-test.properties")
class EditorasApplicationIT {

    private @Autowired EditoraController controller;
    private @Autowired EditoraService service;
    private @Autowired TokenService token;
    private @Autowired ValidationService validation;
    private @Autowired ApagarEditoraUseCase apagarUC;
    private @Autowired AtualizarEditoraUseCase atualizarUC;
    private @Autowired ConsultarEditoraUseCase consultarUC;
    private @Autowired CriarEditoraUseCase criarUC;
    private @Autowired ListarEditorasUseCase listarUC;

    @Test
    void contextLoads() {
        assertNotNull(controller);
        assertNotNull(service);
        assertNotNull(token);
        assertNotNull(validation);
        assertNotNull(apagarUC);
        assertNotNull(atualizarUC);
        assertNotNull(consultarUC);
        assertNotNull(criarUC);
        assertNotNull(listarUC);
    }

}
