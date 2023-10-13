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
public class ImagensPost extends AbstractImagens {

    @OneToOne
    @JoinColumn(name = "id_post")
    @JsonIgnore
    private Post post;

}
