package com.tabletale.rpgwiki.domain.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

        @Column(name = "dataPost")
        @Temporal(TemporalType.TIMESTAMP)
        private Date dataPost;

        @Column(name = "dataEdicao")
        @Temporal(TemporalType.TIMESTAMP)
        private Date dataEdicao;

        @Column(name = "likes")
        private int likes;

        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "id_usuario_fk")
        private Usuario usuario;

        @ManyToMany
        @JoinTable(name = "usuario_curtidas", joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns = @JoinColumn(name = "usuario_id"), uniqueConstraints = @UniqueConstraint(columnNames = {
                        "post_id", "usuario_id" }))
        private Set<Usuario> usuariosQueCurtiram;

        @OneToMany(mappedBy = "postagem")
        private List<Curtida> curtidas;

        @OneToMany(mappedBy = "post", orphanRemoval = true, cascade = { CascadeType.PERSIST,
                        CascadeType.MERGE }, fetch = FetchType.EAGER)
        @Setter(value = AccessLevel.NONE)
        private List<Comentario> comentarios;

}
