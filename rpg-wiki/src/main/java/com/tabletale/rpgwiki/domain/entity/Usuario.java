package com.tabletale.rpgwiki.domain.entity;

import java.io.File;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private String usernameInstragram;
    private String usernameFacebook;
    private String usernameTwitter;
    private String pathImagemPerfil;

    public Usuario(String nome, Pais pais, String email, Genero genero, String biografia, String senha, LocalDate dataNascimento, UserRole role) {
        this.nome = nome;
        this.genero = genero;
        this.pais = pais;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.role = role;
        this.usernameInstragram = "";
        this.usernameFacebook = "";
        this.usernameTwitter = "";
        if (biografia == null) {
            this.biografia = "Estou pronto para a próxima jornada e para enfrentar qualquer desafio que o mundo de RPG possa oferecer!";
        }
        else{
            this.biografia = biografia;
        }
    }

    // Função utilizada para que o usuário possa selecionar qualquer foto que esteja em alguma pasta no local de armazenado do seu aparelho, ou seja no disco.
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
