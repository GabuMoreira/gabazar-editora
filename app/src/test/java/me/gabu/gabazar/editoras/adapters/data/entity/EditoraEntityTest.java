package me.gabu.gabazar.editoras.adapters.data.entity;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EditoraEntityTest {

    private EditoraEntity entity;

    @BeforeEach
    public void beforeEach() {
        entity = new EditoraEntity();

        assertNull(entity.getId());
        assertNull(entity.getDataCriacao());
        assertNull(entity.getDataAlteracao());
    }

    @AfterEach
    public void afterAll() {
        entity.postRemoval();
    }

    @Test
    void prePersist() {
        entity.prePersist();
        assertNotNull(entity.getId());
        assertNotNull(entity.getDataCriacao());
        entity.postPersist();
    }

    @Test
    void preUpdate() {
        entity.preUpdate();
        assertNotNull(entity.getDataAlteracao());
        entity.postUpdate();
    }
}
