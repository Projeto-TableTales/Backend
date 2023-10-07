package com.tabletale.rpgwiki.domain.entity;


import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "post")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post extends AbstractEntity<String> {

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "conteudo")
    private String conteudo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPost;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEdicao;

    private int curtidas;

    @OneToMany(mappedBy = "post", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @Setter(value = AccessLevel.NONE)
    private List<Comentario> comentarios;

    public Post(String titulo, String conteudo, Date dataPost){
        this.conteudo= conteudo;
        this.titulo = titulo;
        this.dataPost = new Date();
    }

}