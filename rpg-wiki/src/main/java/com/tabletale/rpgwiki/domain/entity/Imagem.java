package com.tabletale.rpgwiki.domain.entity;

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
    private Post postagem;


    public Imagem(String nome, String caminho){
        setNome(nome);
        setCaminho(caminho);

    }

}