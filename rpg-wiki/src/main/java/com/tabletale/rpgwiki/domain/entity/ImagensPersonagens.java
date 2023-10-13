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
public class ImagensPersonagens extends AbstractImagens {

    @OneToOne
    @JoinColumn(name = "id_personagem")
    @JsonIgnore
    private Personagem personagem;

    public ImagensPersonagens(String nome, String caminho, Personagem personagem) {
        setNome(nome);
        setCaminho(caminho);
        this.personagem = personagem;
    }


}
