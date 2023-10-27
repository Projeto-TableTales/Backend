package com.tabletale.rpgwiki.domain.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Curtida {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @ManyToOne
     private Usuario usuario;

     @ManyToOne
     private Post postagem;

     @ManyToOne
     private Personagem personagem;

     @ManyToOne
     private Comentario comentario;

     @Temporal(TemporalType.TIMESTAMP)
     private Date dataCurtida;

}
