package me.gabu.gabazar.editoras.adapters.data.entity.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import me.gabu.gabazar.editoras.adapters.data.entity.EditoraEntity;
import me.gabu.gabazar.editoras.core.model.Editora;

@Mapper
public interface EditoraEntityMapper {

    EditoraEntityMapper INSTANCE = Mappers.getMapper(EditoraEntityMapper.class);

    EditoraEntity editoraToEditoraEntity(Editora editora);

    Editora editoraEntityToEditora(EditoraEntity editoraEntity);

    Collection<EditoraEntity> editoraToEditoraEntity(Collection<Editora> editora);

    Collection<Editora> editoraEntityToEditora(Collection<EditoraEntity> editoraEntity);

}
