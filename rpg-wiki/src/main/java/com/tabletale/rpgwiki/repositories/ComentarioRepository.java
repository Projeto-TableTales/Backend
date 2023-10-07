package com.tabletale.rpgwiki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tabletale.rpgwiki.domain.entity.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, String> {}