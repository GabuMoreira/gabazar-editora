package me.gabu.gabazar.editoras.adapters.http.in;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.gabu.gabazar.editoras.adapters.http.in.dto.EditoraDTO;
import me.gabu.gabazar.editoras.adapters.http.in.dto.mapper.EditoraDTOMapper;
import me.gabu.gabazar.editoras.core.model.Editora;
import me.gabu.gabazar.editoras.service.EditoraService;
import me.gabu.gabazar.editoras.service.TokenService;

@Slf4j
@RestController
@RequestMapping("/editoras")
public class EditoraController {

    private @Autowired EditoraService service;
    private @Autowired TokenService tokenService;

    private EditoraDTOMapper mapper = EditoraDTOMapper.INSTANCE;

    @PostMapping
    @ApiOperation(value = "Cadastra nova Editora")
    public @ResponseBody EditoraDTO post(@RequestBody EditoraDTO editoraDTO, @RequestHeader("token") String token) {
        log.info("[POST] [/editoras] Request: {}", editoraDTO);

        validaToken(token);

        Editora editora = toModel(editoraDTO);
        Editora editoraCriada = service.criarEditora(editora, getUsuario(token));

        return toDTO(editoraCriada);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Consulta editora já cadastrada pelo ID")
    public @ResponseBody EditoraDTO getByID(@PathVariable("id") String id, @RequestHeader("token") String token) {
        log.info("[GET] [/editoras/{}]", id);

        validaToken(token);

        return toDTO(service.consultarEditora(id));
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Sobrescreve os dados de um editora cadastrada")
    public @ResponseBody EditoraDTO put(@PathVariable("id") String id, @RequestHeader("token") String token,
            @RequestBody EditoraDTO editoraDTO) {
        log.info("[PUT] [/editoras/{}] Request: {}", id, editoraDTO);

        validaToken(token);

        Editora editora = toModel(editoraDTO);
        editora.setId(id);

        return toDTO(service.atualizarEditora(editora, getUsuario(token)));
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Apaga o registro de uma editora")
    public ResponseEntity<EditoraDTO> delete(@PathVariable("id") String id, @RequestHeader("token") String token) {
        log.info("[DELETE] [/editoras/{}]", id);

        validaToken(token);

        service.apagarEditora(id, getUsuario(token));

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping
    @ApiOperation(value = "Lista todos as editoras cadastradas, podendo ser filtrado do nome da editora")
    public @ResponseBody Collection<EditoraDTO> get(@RequestParam(required = false) String nome,
            @RequestHeader("token") String token) {
        validaToken(token);

        return toDTO(service.listarEditoras(nome));
    }

    private String getUsuario(String token) {
        return tokenService.recuperarUsuario(token);
    }

    private void validaToken(String token) {
        tokenService.validaToken(token);
    }

    protected Collection<EditoraDTO> toDTO(Collection<Editora> editora) {
        return mapper.modelToDto(editora);
    }

    protected EditoraDTO toDTO(Editora editora) {
        return mapper.modelToDto(editora);
    }

    protected Editora toModel(EditoraDTO editoraDTO) {
        return mapper.dtoToModel(editoraDTO);
    }

}
