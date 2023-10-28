package com.tabletale.rpgwiki.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "imagens")
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String caminho;

    @ManyToOne
    @JsonIgnore
    private Post imgPostagem;
    
    @ManyToOne
    @JsonIgnore
    private Comentario imgComentario;

    @OneToOne
    @JsonIgnore
    private Usuario imgPerfil;

    @OneToOne
    @JsonIgnore
    private Usuario imgCapa;

    public Imagem(String nome, String caminho, Post imgPostagem, Comentario imgComentario, Usuario imgPerfil,
            Usuario imgCapa) {
        setNome(nome);
        setCaminho(caminho);
        setImgPostagem(imgPostagem);
        setImgComentario(imgComentario);
        setImgPerfil(imgPerfil);
        setImgCapa(imgCapa);

    }

}