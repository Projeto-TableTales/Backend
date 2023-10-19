package com.tabletale.rpgwiki.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "imagens_personagens")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImagemPersonagem extends AbstractImagem {

    @OneToOne
    @JoinColumn(name = "id_personagem_fk")
    @JsonIgnore
    private Personagem personagem;

    public ImagemPersonagem(String nome, String caminho, Personagem personagem) {
        setNome(nome);
        setCaminho(caminho);
        this.personagem = personagem;
    }


}
