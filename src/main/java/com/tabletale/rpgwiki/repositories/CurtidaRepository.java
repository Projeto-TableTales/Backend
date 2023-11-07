package com.tabletale.rpgwiki.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tabletale.rpgwiki.domain.entity.Curtida;
import com.tabletale.rpgwiki.domain.entity.Post;
import com.tabletale.rpgwiki.domain.entity.Usuario;

@Repository
public interface CurtidaRepository extends JpaRepository<Curtida, Long> {
    Curtida findByPostagemAndUsuario(Post postagem, Usuario usuario);
}