package me.gabu.gabazar.editoras.adapters.html.in.dto.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import me.gabu.gabazar.editoras.adapters.html.in.dto.EditoraDTO;
import me.gabu.gabazar.editoras.core.model.Editora;

@Mapper
public interface EditoraDTOMapper {

    EditoraDTOMapper INSTANCE = Mappers.getMapper(EditoraDTOMapper.class);

    EditoraDTO editoraToEditoraDto(Editora editora);

    Editora editoraDtoToEditora(EditoraDTO editoradto);

    Collection<EditoraDTO> editoraToEditoraDto(Collection<Editora> editora);

    Collection<Editora> editoraDtoToEditora(Collection<EditoraDTO> editoradto);

}
