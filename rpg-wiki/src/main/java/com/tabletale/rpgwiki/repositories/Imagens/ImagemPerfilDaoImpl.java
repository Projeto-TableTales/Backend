package com.tabletale.rpgwiki.repositories.Imagens;

import com.tabletale.rpgwiki.domain.entity.entity_imagens.ImagemPerfil;
import com.tabletale.rpgwiki.repositories.dao.AbstractDao;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class ImagemPerfilDaoImpl extends AbstractDao<ImagemPerfil, Long> implements ImagemPerfilDao {

    @Override
    public ImagemPerfil buscarImagemPerfilUsuario(String idUsuario) throws NoResultException {
        String jpql = "select i from ImagemPerfil i where i.usuario = (select u from Usuario u where u.id = '" + idUsuario + "')";
        TypedQuery<ImagemPerfil> typedQuery = getEntityManager().createQuery(jpql, ImagemPerfil.class);
        ImagemPerfil imagemPerfil = typedQuery.getSingleResult();
        return imagemPerfil;
    }

}
