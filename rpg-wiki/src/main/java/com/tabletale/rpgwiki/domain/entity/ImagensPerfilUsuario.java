package com.tabletale.rpgwiki.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "imagens_perfil_usuario")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImagensPerfilUsuario extends AbstractImagens {

    @OneToOne
    @JoinColumn(name = "id_usuario")
    @JsonIgnore
    private Usuario usuario;

    public ImagensPerfilUsuario(String nome, String caminho, Usuario usuario) {
        setNome(nome);
        setCaminho(caminho);
        this.usuario = usuario;
    }

}
