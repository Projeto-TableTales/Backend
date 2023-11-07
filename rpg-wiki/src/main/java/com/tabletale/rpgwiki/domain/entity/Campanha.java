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
@Table(name = "Campanhas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Campanha extends AbstractEntity<String>{

    @Column(name = "nome_campanha", nullable = false, length = 60)
    private String nomeCampanha;

    @Column(name = "quantidade_participantes")
    private int quantParticipante;

    
    @ManyToOne
    @JsonIgnore
    private Imagem imgCampanha;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "usuario_criador_fk")
    private Usuario criadorCampanha;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "Campanha_Participante", joinColumns = @JoinColumn(name = "campanha_id") , inverseJoinColumns =  @JoinColumn(name = "usuario_id") )
    private List<Usuario> participantes = new ArrayList<>();

    public Campanha(String nomeCampanha) {
        this.nomeCampanha = nomeCampanha;
        this.quantParticipante = 0;
    }

    public void receberSeguidor(Usuario usuario) {
        this.participantes.add(usuario);
        this.quantParticipante++;
    }

    public void retirarSeguidor(Usuario usuario) {
        this.participantes.remove(usuario);
        this.quantParticipante--;
    }

}
