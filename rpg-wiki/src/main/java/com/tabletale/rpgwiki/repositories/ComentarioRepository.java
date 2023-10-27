package com.tabletale.rpgwiki.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tabletale.rpgwiki.domain.entity.Comentario;
import com.tabletale.rpgwiki.domain.entity.Post;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, String>  {
     List<Comentario> findByPost(Post idPost);
 }

