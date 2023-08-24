package com.tabletale.rpgwiki.domain.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "Usuarios")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false, unique = true)
    @Email
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    private UserRole role;

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

    public Usuario(String email, String senha, UserRole role) {
        this.email = email;
        this.senha = senha;
        this.role = role;
    }

    public Usuario(String id, String nome, String email, String senha, String biografia, Genero genero, Pais pais,
            List<Personagem> pesronoagens, List<Mesa> mesasMestradas, UserRole role) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.biografia = biografia;
        this.genero = genero;
        this.pais = pais;
        this.pesronoagens = pesronoagens;
        this.mesasMestradas = mesasMestradas;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN)
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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

    public List<Mesa> getMesasMestradas() {
        return mesasMestradas;
    }

    public void setMesasMestradas(List<Mesa> mesasMestradas) {
        this.mesasMestradas = mesasMestradas;
    }

}
