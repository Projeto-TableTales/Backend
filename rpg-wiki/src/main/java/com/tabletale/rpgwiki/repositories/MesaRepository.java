package com.tabletale.rpgwiki.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tabletale.rpgwiki.domain.entity.Mesa;

public interface MesaRepository extends JpaRepository<Mesa, String> {
    List<Mesa> findByNomeDoJogo(String nomeDoJogo);
    
}
