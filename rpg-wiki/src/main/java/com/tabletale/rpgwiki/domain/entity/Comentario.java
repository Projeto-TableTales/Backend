package com.tabletale.rpgwiki.domain.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comentario")
@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comentario extends AbstractEntity<String> {


    @Column(name = "conteudo")
    private String conteudo;
    
    @Column(name = "likes")
    private int likes;
    
    @Temporal(TemporalType.TIMESTAMP)
    private  Date dataComentario;

        @OneToMany(mappedBy = "imgComentario",orphanRemoval = true, cascade = { CascadeType.PERSIST,
            CascadeType.MERGE }, fetch = FetchType.EAGER)
    private List<Imagem> imagensDoComentario;
    
    @ManyToOne
    @JoinColumn(name = "id_post")
    @JsonIgnore
    private Post post;
    

}