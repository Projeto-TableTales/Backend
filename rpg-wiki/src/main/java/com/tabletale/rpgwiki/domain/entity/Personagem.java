package com.tabletale.rpgwiki.domain.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Personagens")
public class Personagem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

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
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

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

    public Personagem(String id, String nome, String historia, int idade, String classe, String raca, int nivel,
            Date dataCriacao, String status, int dano, int forca, int defesa, int agilidade, int inteligencia,
            int sabedoria, int carisma, int abates, int assistencia, Usuario usuario, Mesa mesa) {
        this.id = id;
        this.nome = nome;
        this.historia = historia;
        this.idade = idade;
        this.classe = classe;
        this.raca = raca;
        this.nivel = nivel;
        this.dataCriacao = dataCriacao;
        this.status = status;
        this.dano = dano;
        this.forca = forca;
        this.defesa = defesa;
        this.agilidade = agilidade;
        this.inteligencia = inteligencia;
        this.sabedoria = sabedoria;
        this.carisma = carisma;
        this.abates = abates;
        this.assistencia = assistencia;
        this.usuario = usuario;
        this.mesa = mesa;
    }

    public Personagem() {
    }

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

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

}