package com.tabletale.rpgwiki.repositories.dao;

import com.tabletale.rpgwiki.domain.entity.ImagemPerfil;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class ImagemPerfilDaoImpl extends AbstractDao<ImagemPerfil, Long> implements ImagemPerfilDao {

    @Override
    public ImagemPerfil buscarImagemPerfilUsuario(String idUsuario) {
        String jpql = "select i from ImagemPerfil i where i.usuario = (select u from Usuario u where u.id = '" + idUsuario + "')";
        TypedQuery<ImagemPerfil> typedQuery = getEntityManager().createQuery(jpql, ImagemPerfil.class);
        ImagemPerfil imagemPerfil = typedQuery.getSingleResult();
        return imagemPerfil;
    }

}
