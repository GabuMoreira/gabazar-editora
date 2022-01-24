package me.gabu.gabazar.editoras.adapters.http.in;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import me.gabu.gabazar.editoras.adapters.http.in.dto.EditoraDTO;
import me.gabu.gabazar.editoras.core.model.Editora;
import me.gabu.gabazar.editoras.service.EditoraService;
import me.gabu.gabazar.editoras.service.TokenService;

@ExtendWith(MockitoExtension.class)
class EditoraControllerTest {

    private static final String NOME_EDITORA = "NOME EDITORA";
    private static final String ID_EDITORA = UUID.randomUUID().toString();
    private static final String TOKEN = UUID.randomUUID().toString();
    private static final String USUARIO = "USUARIO";

    private EditoraDTO dto;
    private Editora model;

    private @Mock EditoraService service;
    private @Mock TokenService tokenService;

    private @InjectMocks @Spy EditoraController controller;

    @BeforeEach
    public void beforeEach() {
        dto = EditoraDTO.builder().build();
        model = Editora.builder().build();
    }

    @AfterEach
    public void afterEach() {
        verifyNoMoreInteractions(service);
        verifyNoMoreInteractions(tokenService);
    }

    @Test
    void post() {
        doNothing().when(tokenService).validaToken(TOKEN);
        when(tokenService.recuperarUsuario(TOKEN)).thenReturn(USUARIO);
        when(controller.toModel(dto)).thenReturn(model);
        when(service.criarEditora(model, USUARIO)).thenReturn(model);
        when(controller.toDTO(model)).thenReturn(dto);

        controller.post(dto, TOKEN);

        verify(tokenService, times(1)).validaToken(TOKEN);
        verify(tokenService, times(1)).recuperarUsuario(TOKEN);
        verify(service, times(1)).criarEditora(model, USUARIO);
    }

    @Test
    void getByID() {
        doNothing().when(tokenService).validaToken(TOKEN);
        when(service.consultarEditora(ID_EDITORA)).thenReturn(model);

        controller.getByID(ID_EDITORA, TOKEN);

        verify(tokenService, times(1)).validaToken(TOKEN);
        verify(service, times(1)).consultarEditora(ID_EDITORA);
    }

    @Test
    void put() {
        doNothing().when(tokenService).validaToken(TOKEN);
        when(controller.toModel(dto)).thenReturn(model);
        when(tokenService.recuperarUsuario(TOKEN)).thenReturn(USUARIO);
        when(service.atualizarEditora(model, USUARIO)).thenReturn(model);

        EditoraDTO response = controller.put(ID_EDITORA, TOKEN, dto);

        assertEquals(ID_EDITORA, response.getId());

        verify(tokenService, times(1)).validaToken(TOKEN);
        verify(tokenService, times(1)).recuperarUsuario(TOKEN);
        verify(service, times(1)).atualizarEditora(model, USUARIO);
    }

    @Test
    void delete() {
        doNothing().when(tokenService).validaToken(TOKEN);
        when(tokenService.recuperarUsuario(TOKEN)).thenReturn(USUARIO);
        doNothing().when(service).apagarEditora(ID_EDITORA, USUARIO);

        ResponseEntity<EditoraDTO> delete = controller.delete(ID_EDITORA, TOKEN);

        assertEquals(HttpStatus.NO_CONTENT, delete.getStatusCode());

        verify(tokenService, times(1)).validaToken(TOKEN);
        verify(tokenService, times(1)).recuperarUsuario(TOKEN);
        verify(service, times(1)).apagarEditora(ID_EDITORA, USUARIO);
    }

    @Test
    void get() {
        doNothing().when(tokenService).validaToken(TOKEN);
        when(service.listarEditoras(NOME_EDITORA)).thenReturn(Arrays.asList(model));

        Collection<EditoraDTO> lista = controller.get(NOME_EDITORA, TOKEN);

        assertEquals(1, lista.size());

        verify(tokenService, times(1)).validaToken(TOKEN);
        verify(service, times(1)).listarEditoras(NOME_EDITORA);
    }

}
