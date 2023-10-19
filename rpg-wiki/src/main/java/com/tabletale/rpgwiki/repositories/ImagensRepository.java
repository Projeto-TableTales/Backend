package com.tabletale.rpgwiki.repositories;

import java.util.List;

import com.tabletale.rpgwiki.domain.entity.ImagemPost;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tabletale.rpgwiki.domain.entity.AbstractImagem;

public interface ImagensRepository extends JpaRepository<AbstractImagem, Long>{
    public List<ImagemPost> findByPostId(Long id);
}