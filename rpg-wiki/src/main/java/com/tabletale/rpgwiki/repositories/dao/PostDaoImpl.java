package com.tabletale.rpgwiki.repositories.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tabletale.rpgwiki.domain.entity.Post;

import jakarta.persistence.TypedQuery;

@Repository
public class PostDaoImpl extends AbstractDao<Post, String> implements PostDao{
    @Override
    public List<Post> findByTitulo(String titulo) {
        String jpql = "select p from Post p where u.titulo = '" + titulo + "'";
        TypedQuery<Post> typedQuery = getEntityManager().createQuery(jpql, Post.class);
        List<Post> lista = typedQuery.getResultList();
        lista.forEach(p -> System.out.println(p.getId() + ", " + p.getTitulo()));
        return lista;
    }

}
