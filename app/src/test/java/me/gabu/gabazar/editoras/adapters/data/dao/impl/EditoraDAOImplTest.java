package me.gabu.gabazar.editoras.adapters.data.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import me.gabu.gabazar.editoras.adapters.data.entity.EditoraEntity;
import me.gabu.gabazar.editoras.adapters.data.entity.mapper.EditoraEntityMapper;
import me.gabu.gabazar.editoras.adapters.data.repository.EditoraRepository;
import me.gabu.gabazar.editoras.core.exceptions.NotFoundException;
import me.gabu.gabazar.editoras.core.model.Editora;

@ExtendWith(MockitoExtension.class)
class EditoraDAOImplTest {

    private static final String EXC_EDITORA_NAO_ENCONTRADA = "Editora não encontrada";
    private static final String EDITORA_ID = UUID.randomUUID().toString();
    private static final String NOME = "nome";

    private @Mock EditoraRepository repository;
    private @Mock EditoraEntityMapper mapper;
    private @InjectMocks @Spy EditoraDAOImpl dao;

    private EditoraEntity entity = new EditoraEntity();
    private Editora model = Editora.builder().build();

    @AfterEach
    public void afterEach() {
        verifyNoMoreInteractions(repository);
    }

    @Test
    void findById() {
        when(repository.findById(EDITORA_ID)).thenReturn(Optional.of(entity));
        when(dao.getMapper()).thenReturn(mapper);
        when(mapper.editoraEntityToEditora(entity)).thenReturn(model);

        dao.findById(EDITORA_ID);

        verify(repository, times(1)).findById(EDITORA_ID);
    }

    @Test
    void findByIdNotFoundException() {
        when(repository.findById(EDITORA_ID)).thenReturn(Optional.empty());

        NotFoundException assertThrows = assertThrows(NotFoundException.class, () -> {
            dao.findById(EDITORA_ID);
        });

        assertEquals(EXC_EDITORA_NAO_ENCONTRADA, assertThrows.getMessage());

        verify(repository, times(1)).findById(EDITORA_ID);
    }

    @Test
    void save() {
        when(repository.save(entity)).thenReturn(entity);
        when(dao.getMapper()).thenReturn(mapper);
        when(mapper.editoraEntityToEditora(entity)).thenReturn(model);
        when(mapper.editoraToEditoraEntity(model)).thenReturn(entity);

        dao.save(model);

        verify(repository, times(1)).save(entity);
    }

    @Test
    void listAll() {
        when(repository.findAll()).thenReturn(Arrays.asList(entity));
        when(dao.getMapper()).thenReturn(mapper);
        when(mapper.editoraEntityToEditora(Arrays.asList(entity))).thenReturn(Arrays.asList(model));

        dao.listAll();

        verify(repository, times(1)).findAll();
    }

    @Test
    void findByNome() {
        when(repository.findByNome(NOME)).thenReturn(Arrays.asList(entity));
        when(dao.getMapper()).thenReturn(mapper);
        when(mapper.editoraEntityToEditora(Arrays.asList(entity))).thenReturn(Arrays.asList(model));

        dao.findByNome(NOME);

        verify(repository, times(1)).findByNome(NOME);
    }

    @Test
    void update() {
        when(repository.save(entity)).thenReturn(entity);
        when(dao.getMapper()).thenReturn(mapper);
        when(mapper.editoraEntityToEditora(entity)).thenReturn(model);
        when(mapper.editoraToEditoraEntity(model)).thenReturn(entity);

        dao.update(model);

        verify(repository, times(1)).save(entity);
    }

    @Test
    void delete() {
        doNothing().when(repository).deleteById(EDITORA_ID);

        model.setId(EDITORA_ID);
        dao.delete(model);

        verify(repository, times(1)).deleteById(EDITORA_ID);
    }

}
