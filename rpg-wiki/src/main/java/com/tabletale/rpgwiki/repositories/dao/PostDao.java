package com.tabletale.rpgwiki.repositories.dao;

import java.util.List;

import com.tabletale.rpgwiki.domain.entity.Post;

public interface PostDao {

    void save(Post post);

    void update(Post post);

    void delete(String id);

    Post findById(String id);

    List<Post> findAll();

    List<Post> findByTitulo(String titulo);
}
