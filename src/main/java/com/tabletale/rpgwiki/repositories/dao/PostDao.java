package com.tabletale.rpgwiki.repositories.dao;

import java.util.List;

import com.tabletale.rpgwiki.domain.entity.Post;

public interface PostDao {

    void save(Post post);

    void update(Post post);

    void delete(String idPost);

    Post findById(String idPost);

    List<Post> findAll();

    List<Post> buscarAllPost(String idUser);

    List<Post> findByTitulo(String titulo);
}
