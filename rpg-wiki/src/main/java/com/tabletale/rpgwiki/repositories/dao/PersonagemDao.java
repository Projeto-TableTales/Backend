package com.tabletale.rpgwiki.repositories.dao;

import com.tabletale.rpgwiki.domain.entity.Personagem;

import java.util.List;

public interface PersonagemDao {

    void save(Personagem personagem);

    void update(Personagem personagem);

    void delete(String id);

    Personagem findById(String id);

    List<Personagem> findAll();

    List<Personagem> findByName(String nome);

    List<Personagem> buscarTodosPersonagensDoUsuario(String id);

}
