package com.tabletale.rpgwiki.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Personagens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Personagem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "historia")
    private String historia;

    @Column(name = "idade")
    private int idade;

    @Column(name = "classe")
    private String classe;

    @Column(name = "raca")
    private String raca;

    @Column(name = "nivel")
    private int nivel;

    @Column(name = "data_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Column(name = "data_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    @Column(name = "status")
    private String status;

    @Column(name = "dano")
    private int dano;

    @Column(name = "forca")
    private int forca;

    @Column(name = "defesa")
    private int defesa;

    @Column(name = "agilidade")
    private int agilidade;

    @Column(name = "inteligencia")
    private int inteligencia;

    @Column(name = "sabedoria")
    private int sabedoria;

    @Column(name = "carisma")
    private int carisma;

    @Column(name = "abates")
    private int abates;

    @Column(name = "assistencia")
    private int assistencia;

    @ManyToOne
    @JoinColumn(name = "usuario_id_fk")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "mesa_id_fk")
    private Mesa mesa;



}