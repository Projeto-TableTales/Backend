package com.tabletale.rpgwiki.domain.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comentario")
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comentario extends AbstractEntity<String> {

    @Column(name = "conteudo")
    private String conteudo;

    @Column(name = "likes")
    private int likes;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataComentario;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_usuario_fk")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_post")
    @JsonIgnore
    private Post post;

}