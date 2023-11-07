package com.tabletale.rpgwiki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.tabletale.rpgwiki.domain.entity.Imagem;


@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Long>  { }
