package me.gabu.gabazar.editoras.adapters.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.gabu.gabazar.editoras.adapters.data.entity.EditoraEntity;

@Repository
public interface EditoraRepository extends JpaRepository<EditoraEntity, String> {

}
