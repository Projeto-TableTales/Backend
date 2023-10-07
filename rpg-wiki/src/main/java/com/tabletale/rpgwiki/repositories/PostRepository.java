package com.tabletale.rpgwiki.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tabletale.rpgwiki.domain.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {
    List<Post> findByTitulo(String titulo);
}
