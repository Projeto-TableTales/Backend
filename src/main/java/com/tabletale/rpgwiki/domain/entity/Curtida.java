package com.tabletale.rpgwiki.domain.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curtida {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @ManyToOne
     private Usuario usuario;

     @JsonIgnore
     @ManyToOne
     private Post postagem;

     @ManyToOne
     private Personagem personagem;

     @ManyToOne
     private Comentario comentario;

     @Temporal(TemporalType.TIMESTAMP)
     private Date dataCurtida;

}
