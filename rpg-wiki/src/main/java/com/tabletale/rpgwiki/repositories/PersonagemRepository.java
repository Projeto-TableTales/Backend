package com.tabletale.rpgwiki.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tabletale.rpgwiki.domain.entity.Personagem;

public interface PersonagemRepository extends JpaRepository<Personagem, String> {
    List<Personagem> findByNome(String nome);

}