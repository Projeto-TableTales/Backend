package com.tabletale.rpgwiki.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tabletale.rpgwiki.domain.entity.Imagens;

public interface ImagensRepository extends JpaRepository<Imagens, Long>{
    public List<Imagens> findByPostId(Long id);
}