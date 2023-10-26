package com.tabletale.rpgwiki.domain.entity.entity_imagens;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tabletale.rpgwiki.domain.entity.Post;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "imagens_post")
@Data
@EqualsAndHashCode(callSuper=false)
public class ImagemPost extends AbstractImagem {

    @ManyToOne
    @JoinColumn(name = "id_post_fk")
    @JsonIgnore
    private Post post;

    public ImagemPost(String nome, String caminho, Post post) {
        setNome(nome);
        setCaminho(caminho);
        this.post = post;
    }
}
