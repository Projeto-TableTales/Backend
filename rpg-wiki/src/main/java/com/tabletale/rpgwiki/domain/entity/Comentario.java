package com.tabletale.rpgwiki.domain.entity;

import java.util.Date;

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
    
    @Temporal(TemporalType.TIMESTAMP)
    private  Date dataComentario;
    
    @ManyToOne
    @JoinColumn(name = "id_post")
    @JsonIgnore
    private Post post;
    
    public Comentario(String conteudo, Date dataComentario) {
        this.conteudo = conteudo;
        this.dataComentario = dataComentario;
    }
}