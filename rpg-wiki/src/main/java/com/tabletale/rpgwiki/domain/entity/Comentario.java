package com.tabletale.rpgwiki.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "comentario")
@Data
@EqualsAndHashCode(callSuper=false)
public class Comentario extends AbstractEntity<String> {

    @Column(name = "conteudo")
    private String conteudo;
    
    @Column(name = "curtidas")
    private int curtidas;

    @ManyToOne
    @JoinColumn(name = "id_post")
    @JsonIgnore
    private Post post;

}