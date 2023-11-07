package com.tabletale.rpgwiki.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Personagens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Personagem extends AbstractEntity<String>{

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "idade")
    private int idade;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "sistema_rpg", nullable = false)
    private String sistemaDoRPG;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "personalidade")
    private String personalidade;

    @Column(name = "likes")
    private int likes;

    @Column(name = "historia")
    private String historia;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "usuario_id_fk")
    private Usuario usuario;

    
    public Personagem(String nome, int idade,  String status, String sistemaDoRPG, String descricao, String personalidade, String historia) {
        this.nome = nome;
        this.idade = idade;
        this.status = status;
        this.sistemaDoRPG = sistemaDoRPG;
        this.descricao = descricao;
        this.personalidade = personalidade;
        this.likes = 0;
        this.historia = historia;
    }

}