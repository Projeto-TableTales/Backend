package com.tabletale.rpgwiki.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "imagens_post")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImagemPost extends AbstractImagem {

    @OneToOne
    @JoinColumn(name = "id_post_fk")
    @JsonIgnore
    private Post post;

}
