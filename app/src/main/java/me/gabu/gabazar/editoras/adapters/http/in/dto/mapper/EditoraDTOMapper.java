package me.gabu.gabazar.editoras.adapters.http.in.dto.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import me.gabu.gabazar.editoras.adapters.http.in.dto.EditoraDTO;
import me.gabu.gabazar.editoras.core.model.Editora;

@Mapper
public interface EditoraDTOMapper {

    EditoraDTOMapper INSTANCE = Mappers.getMapper(EditoraDTOMapper.class);

    EditoraDTO modelToDto(Editora editora);

    Editora dtoToModel(EditoraDTO editoradto);

    Collection<EditoraDTO> modelToDto(Collection<Editora> editora);

}
