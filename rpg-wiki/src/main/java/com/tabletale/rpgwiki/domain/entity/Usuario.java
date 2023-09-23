package com.tabletale.rpgwiki.domain.entity;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tabletale.rpgwiki.domain.entity.enums.Genero;
import com.tabletale.rpgwiki.domain.entity.enums.Pais;
import com.tabletale.rpgwiki.domain.entity.enums.UserRole;
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

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

@Entity
@Table(name = "Usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario extends AbstractEntity<String> implements UserDetails  {

    @Column(name = "nome")
    private String nome;

    @NotNull
    @Email
    private String email;

    private String senha;

    private UserRole role;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Enumerated(EnumType.STRING)
    private Pais pais;

    @Column(columnDefinition = "DATE")
    @Past
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDate dataNascimento;

    private String codigoRecuperacaoSenha;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEnvioCodigo;

    @OneToMany(mappedBy = "usuario")
    private List<Personagem> pesronoagens;

    @OneToMany(mappedBy = "usuarioMestre")
    private List<Mesa> mesasMestradas;

    @Column(name = "biografia")
    private String biografia;

    @Column(name = "name_instagram")
    private String usernameInstragram;

    @Column(name = "name_facebook")
    private String usernameFacebook;

    @Column(name = "name_twitter")
    private String usernameTwitter;

    @Column(name = "path_foto_perfil")
    private String pathImagemPerfil;

    private List<String> rpgsFavoritos;


    public Usuario(String nome, Pais pais, String email, Genero genero, String senha, LocalDate dataNascimento, UserRole role) {
        this.nome = nome;
        this.genero = genero;
        this.pais = pais;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.role = role;
        this.biografia = "Estou pronto para a próxima jornada e para enfrentar qualquer desafio que o mundo de RPG possa oferecer!";
        this.usernameInstragram = "";
        this.usernameFacebook = "";
        this.usernameTwitter = "";
        this.rpgsFavoritos = new ArrayList<>();
    }

    public static File mostrarEscolhaFoto() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Arquivos de Imagem", "jpg", "jpeg", "png", "gif");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File arquivoSelecionado = chooser.getSelectedFile();
            return arquivoSelecionado;
        }
        return null;
    }

    public void adicionarRPGSFavoritos(String nomeRPG) {
        this.rpgsFavoritos.add(nomeRPG);
    }

    public void removerRPGSFavoritos(String nomeRPG) {
        this.rpgsFavoritos.remove(nomeRPG);
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
