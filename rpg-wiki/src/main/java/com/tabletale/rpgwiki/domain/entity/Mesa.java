package com.tabletale.rpgwiki.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Mesas")
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "nome_do_Jogo", nullable = false)
    private String nomeDoJogo;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "data_criacao", nullable = false, columnDefinition = "DATE")
    private LocalDate dataCriacao;

    @Column(name = "numero_maximo_user", nullable = false)
    private int numeroMax;

    @ManyToOne
    @JoinColumn(name = "usuario_mestre_id_fk")
    private Usuario usuarioMestre;

    @OneToMany(mappedBy = "mesa")
    private List<Personagem> personagensDaMesa;

    public Mesa(String id, String nomeDoJogo, String descricao, LocalDate dataCriacao, int numeroMax,
            Usuario usuarioMestre,
            List<Personagem> personagensDaMesa) {
        this.id = id;
        this.nomeDoJogo = nomeDoJogo;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.numeroMax = numeroMax;
        this.usuarioMestre = usuarioMestre;
        this.personagensDaMesa = personagensDaMesa;
    }

    public Mesa() {

    }

    public String getNomeDoJogo() {
        return nomeDoJogo;
    }

    public void setNomeDoJogo(String nomeDoJogo) {
        this.nomeDoJogo = nomeDoJogo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public int getNumeroMax() {
        return numeroMax;
    }

    public void setNumeroMax(int numeroMax) {
        this.numeroMax = numeroMax;
    }

    public Usuario getUsuarioMestre() {
        return usuarioMestre;
    }

    public void setUsuarioMestre(Usuario usuarioMestre) {
        this.usuarioMestre = usuarioMestre;
    }

    public List<Personagem> getPersonagensDaMesa() {
        return personagensDaMesa;
    }

    public void setPersonagensDaMesa(List<Personagem> personagensDaMesa) {
        this.personagensDaMesa = personagensDaMesa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}