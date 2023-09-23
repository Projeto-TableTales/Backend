package com.tabletale.rpgwiki.repositories.dao;

import com.tabletale.rpgwiki.domain.entity.Mesa;

import java.util.List;

public interface MesaDao {

    void save(Mesa mesa);

    void update(Mesa mesa);

    void delete(String id);

    Mesa findById(String id);

    List<Mesa> findAll();

    List<Mesa> findByNameOfGame(String nomeDoJogo);

}
