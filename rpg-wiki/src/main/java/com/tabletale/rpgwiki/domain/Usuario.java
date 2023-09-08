package com.tabletale.rpgwiki.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "USUARIOS")
public class Usuario extends AbstractEntity<String>{

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "biografia")
    private String biografia;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Enumerated(EnumType.STRING)
    private Pais pais;

    @OneToMany(mappedBy = "usuario")
    private List<Personagem> pesronoagens;

    @OneToMany(mappedBy = "usuarioMestre")
    private List<Mesa> mesasMestradas;


    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Personagem> getPesronoagens() {
        return pesronoagens;
    }

    public void setPesronoagens(List<Personagem> pesronoagens) {
        this.pesronoagens = pesronoagens;
    }

}
