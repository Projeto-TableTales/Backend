package com.tabletale.rpgwiki.dao;

import com.tabletale.rpgwiki.domain.Personagem;

import java.util.List;

public interface PersonagemDao {

    void save(Personagem pesronagem);

    void update(Personagem pesronagem);

    void delete(String id);

    Personagem findById(String id);

    List<Personagem> findAll();

}
