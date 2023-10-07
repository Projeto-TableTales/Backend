package com.tabletale.rpgwiki.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tabletale.rpgwiki.domain.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTitulo(String titulo);

}
