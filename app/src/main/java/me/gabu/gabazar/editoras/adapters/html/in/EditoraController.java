package me.gabu.gabazar.editoras.adapters.html.in;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import me.gabu.gabazar.editoras.adapters.html.dto.EditoraDTO;
import me.gabu.gabazar.editoras.adapters.html.dto.mapper.EditoraDTOMapper;
import me.gabu.gabazar.editoras.core.model.Editora;
import me.gabu.gabazar.editoras.service.EditoraService;
import me.gabu.gabazar.editoras.service.TokenService;

@Slf4j
@Controller
@RequestMapping("/editoras")
public class EditoraController {

    private @Autowired EditoraService service;
    private @Autowired TokenService tokenService;

    private EditoraDTOMapper mapper = EditoraDTOMapper.INSTANCE;

    @PostMapping(produces = "application/json")
    public @ResponseBody EditoraDTO post(@RequestBody EditoraDTO editoraDTO, @RequestHeader("token") String token) {
        log.info("[POST] [/editoras] Request: {}", editoraDTO);

        validaToken(token);
        Editora editora = mapper.editoraDtoToEditora(editoraDTO);
        Editora editoraCriada = service.criarEditora(editora, getUsuario(token));

        return mapper.editoraToEditoraDto(editoraCriada);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public @ResponseBody EditoraDTO getByID(@PathVariable("id") String id, @RequestHeader("token") String token) {
        log.info("[GET] [/editoras/{}]", id);

        validaToken(token);

        return mapper.editoraToEditoraDto(service.consultarEditora(id));
    }

    @PatchMapping(value = "/{id}", produces = "application/json")
    public @ResponseBody EditoraDTO patch(@PathVariable("id") String id, @RequestHeader("token") String token,
            @RequestBody EditoraDTO editoraDTO) {
        log.info("[PATCH] [/editoras/{}] Request: {}", id, editoraDTO);

        validaToken(token);
        Editora editora = mapper.editoraDtoToEditora(editoraDTO);
        editora.setId(id);

        return mapper.editoraToEditoraDto(service.atualizarEditora(editora, getUsuario(token)));
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<EditoraDTO> delete(@PathVariable("id") String id, @RequestHeader("token") String token) {
        log.info("[DELETE] [/editoras/{}]", id);

        validaToken(token);
        service.apagarEditora(id, getUsuario(token));

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping
    public @ResponseBody Collection<EditoraDTO> get(@RequestParam(required = false) String nome,
            @RequestHeader("token") String token) {
        validaToken(token);

        return mapper.editoraToEditoraDto(service.listarEditoras(nome));
    }


    private String getUsuario(String token) {
        return tokenService.recuperarUsuario(token);
    }

    private void validaToken(String token) {
        tokenService.validaToken(token);
    }
}
