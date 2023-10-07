package com.tabletale.rpgwiki.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Personagens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Personagem extends AbstractEntity<String>{

    @Column(name = "nome")
    private String nome;

    @Column(name = "idade", nullable = false)
    private int idade;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "sistema_rpg", nullable = false)
    private String sistemaDoRPG;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "personalidade", nullable = false)
    private String personalidade;

    @Column(name = "tags_personagem")
    private List<String> tagsPersonagem = new ArrayList<>();;

    @Column(name = "likes")
    private int likes;

    @Column(name = "pathImagemPersonagem")
    private String pathImagemPersonagem;

    @Column(name = "historia", nullable = false)
    private String historia;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "usuario_id_fk")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "mesa_id_fk")
    private Mesa mesa;

    public Personagem(String nome, int idade,  String status, String sistemaDoRPG, String descricao, String personalidade, List<String> tagsPersonagem,String historia) {
        this.nome = nome;
        this.idade = idade;
        this.status = status;
        this.sistemaDoRPG = sistemaDoRPG;
        this.descricao = descricao;
        this.personalidade = personalidade;
        this.tagsPersonagem = tagsPersonagem;
        this.likes = 0;
        this.historia = historia;
    }

    public void adicionarTagPersonagem(String tag) {
        this.tagsPersonagem.add(tag);
    }

    public void removerTagPersonagem(String tag) {
        this.tagsPersonagem.remove(tag);
    }

}