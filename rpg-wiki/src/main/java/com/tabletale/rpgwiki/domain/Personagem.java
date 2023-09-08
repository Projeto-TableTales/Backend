package com.tabletale.rpgwiki.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "PERSONAGENS")
public class Personagem extends AbstractEntity<String>{

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "historia", nullable = false)
    private String historia;

    @Column(name = "idade", nullable = false)
    private int idade;

    @Column(name = "classe", nullable = false)
    private String classe;

    @Column(name = "raca", nullable = false)
    private String raca;

    @Column(name = "nivel", nullable = false)
    private int nivel;

    @Column(name = "data_criacao", nullable = false)
    private LocalDate dataCriacao;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "dano", nullable = false)
    private int dano;

    @Column(name = "forca", nullable = false)
    private int forca;

    @Column(name = "defesa", nullable = false)
    private int defesa;

    @Column(name = "agilidade", nullable = false)
    private int agilidade;

    @Column(name = "inteligencia", nullable = false)
    private int inteligencia;

    @Column(name = "sabedoria", nullable = false)
    private int sabedoria;

    @Column(name = "carisma", nullable = false)
    private int carisma;

    @Column(name = "abates", nullable = false)
    private int abates;

    @Column(name = "assistencia", nullable = false)
    private int assistencia;

    @ManyToOne
    @JoinColumn(name = "usuario_id_fk")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "mesa_id_fk")
    private Mesa mesa;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getSabedoria() {
        return sabedoria;
    }

    public void setSabedoria(int sabedoria) {
        this.sabedoria = sabedoria;
    }

    public int getCarisma() {
        return carisma;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }

    public int getAbates() {
        return abates;
    }

    public void setAbates(int abates) {
        this.abates = abates;
    }

    public int getAssistencia() {
        return assistencia;
    }

    public void setAssistencia(int assistencia) {
        this.assistencia = assistencia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
