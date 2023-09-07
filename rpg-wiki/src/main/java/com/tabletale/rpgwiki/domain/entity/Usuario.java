package com.tabletale.rpgwiki.domain.entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "nome")
    private String nome;
    @NotNull
    @Email
    private String email;
    private String senha;
    private UserRole role;
    private String biografia;
    @Enumerated(EnumType.STRING)
    private Genero genero;
    @Enumerated(EnumType.STRING)
    private Pais pais;
    @Temporal(TemporalType.DATE)
    @Past
    private Date dataNascimento;
    private String codigoRecuperacaoSenha;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEnvioCodigo;

    @OneToMany(mappedBy = "usuario")
    private List<Personagem> pesronoagens;
    @OneToMany(mappedBy = "usuarioMestre")
    private List<Mesa> mesasMestradas;

    public Usuario(String nome, Pais pais, String email, Genero genero, String biografia, String senha, Date dataNascimento) {
        this.nome = nome;
        this.biografia = biografia;
        this.genero = genero;
        this.pais = pais;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.MESTRE)
            return List.of(new SimpleGrantedAuthority("ROLE_MESTRE"), new SimpleGrantedAuthority("ROLE_USER"));
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


}
