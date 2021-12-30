package me.gabu.gabazar.editoras.adapters.data.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Entity
@Slf4j
@ToString
@Table(name = "TBGB_EDIT")
public class EditoraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nome;
    private String site;
    private Date dataCriacao;
    private Date dataAlteracao;
    private String usuarioCriacao;
    private String usuarioAlteracao;

    @PrePersist
    public void prePersist() {
        dataCriacao = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        dataAlteracao = new Date();
    }

    @PostPersist
    public void postPersist() {
        log.info("[ENTITY] [POS-PERSIST] Usuario {} cadastrou a editora {}", usuarioCriacao, this);
    }

    @PostUpdate
    public void postUpdate() {
        log.info("[ENTITY] [POS-UPDATE] Usuario {} atualizou os dados da editora {}", usuarioAlteracao, this);
    }

    @PostRemove
    public void postRemoval() {
        log.info("[ENTITY] [POS-REMOVAL] Usuario {} apagou a editora {}", usuarioAlteracao, this);
    }

}
