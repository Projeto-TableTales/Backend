package com.tabletale.rpgwiki.repositories.dao;

import com.tabletale.rpgwiki.domain.entity.ImagemPersonagem;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class ImagemPersonagemDaoImpl extends AbstractDao<ImagemPersonagem, Long> implements ImagemPersonagemDao {

    @Override
    public ImagemPersonagem buscarImagemPersonagem(String idPersonagem) {
        String jpql = "select i from ImagemPersonagem i where i.personagem = (select p from Personagem p where p.id = '" + idPersonagem + "')";
        TypedQuery<ImagemPersonagem> typedQuery = getEntityManager().createQuery(jpql, ImagemPersonagem.class);
        ImagemPersonagem imagemPersonagem = typedQuery.getSingleResult();
        return imagemPersonagem;
    }

}
