package com.tabletale.rpgwiki.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Perfis")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

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

    @OneToOne
    @JoinColumn(name = "id_usuario_fk")
    private Usuario usuario;

    public Perfil(Usuario usuario) {
        this.biografia = "Estou pronto para a próxima jornada e para enfrentar qualquer desafio que o mundo de RPG possa oferecer!";
        this.usernameInstragram = "";
        this.usernameFacebook = "";
        this.usernameTwitter = "";
        this.usuario = usuario;
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


}
