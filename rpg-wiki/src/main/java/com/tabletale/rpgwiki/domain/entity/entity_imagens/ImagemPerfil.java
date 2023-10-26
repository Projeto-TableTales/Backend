package com.tabletale.rpgwiki.domain.entity.entity_imagens;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tabletale.rpgwiki.domain.entity.Usuario;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "imagens_perfil_usuario")
@Data
@EqualsAndHashCode(callSuper=false)
public class ImagemPerfil extends AbstractImagem {

    @OneToOne
    @JoinColumn(name = "id_usuario_fk")
    @JsonIgnore
    private Usuario usuario;

    public ImagemPerfil(String nome, String caminho, Usuario usuario) {
        setNome(nome);
        setCaminho(caminho);
        this.usuario = usuario;
    }

}
