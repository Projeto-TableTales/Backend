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
    

    @OneToOne
    @JsonIgnore
    private Usuario imgPerfil;

    @OneToOne
    @JsonIgnore
    private Usuario imgCapa;

    @OneToOne
    @JsonIgnore
    private Campanha imgCampanha;

    public Imagem(String nome, String caminho, Post imgPostagem, Usuario imgPerfil,
            Usuario imgCapa, Campanha imgCampanha) {
        setNome(nome);
        setCaminho(caminho);
        setImgPostagem(imgPostagem);
        setImgPerfil(imgPerfil);
        setImgCapa(imgCapa);
        setImgCampanha(imgCampanha);

    }

}