package com.tabletale.rpgwiki.dao;

import com.tabletale.rpgwiki.domain.Mesa;

import java.util.List;

public interface MesaDao {

    void save(Mesa mesa);

    void update(Mesa mesa);

    void delete(Long id);

    Mesa findById(Long id);

    List<Mesa> findAll();

}
