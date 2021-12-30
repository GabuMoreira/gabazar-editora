package me.gabu.gabazar.editoras.adapters.html.in;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.gabu.gabazar.editoras.adapters.html.dto.EditoraDTO;
import me.gabu.gabazar.editoras.adapters.html.dto.mapper.EditoraDTOMapper;
import me.gabu.gabazar.editoras.core.model.Editora;
import me.gabu.gabazar.editoras.service.EditoraService;
import me.gabu.gabazar.editoras.service.UsuarioService;

@Controller
@RequestMapping("/editoras")
public class EditoraController {

    @Autowired
    private EditoraService service;
    @Autowired
    private UsuarioService usuarioService;

    private EditoraDTOMapper mapper = EditoraDTOMapper.INSTANCE;

    @PostMapping(produces = "application/json")
    public @ResponseBody EditoraDTO getBook(@RequestBody EditoraDTO editoraDTO, @RequestHeader("token") String token) {
        Editora editora = mapper.editoraDtoToEditora(editoraDTO);
        Editora editoraCriada = service.criarEditora(editora, getUsuario(token));
        return mapper.editoraToEditoraDto(editoraCriada);
    }

    private String getUsuario(String token) {
        return usuarioService.getUsuarioFromToken(token);
    }

}
