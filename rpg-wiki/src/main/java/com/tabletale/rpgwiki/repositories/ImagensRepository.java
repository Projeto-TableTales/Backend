package com.tabletale.rpgwiki.repositories;

import java.util.List;

import com.tabletale.rpgwiki.domain.entity.ImagensPost;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tabletale.rpgwiki.domain.entity.AbstractImagens;

public interface ImagensRepository extends JpaRepository<AbstractImagens, Long>{
    public List<ImagensPost> findByPostId(Long id);
}