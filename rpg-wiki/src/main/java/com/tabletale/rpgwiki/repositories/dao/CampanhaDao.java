package com.tabletale.rpgwiki.repositories.dao;

import com.tabletale.rpgwiki.domain.entity.Campanha;

import java.util.List;

public interface CampanhaDao {

    void save(Campanha campanha);

    void update(Campanha campanha);

    void delete(String id);

    Campanha findById(String id);

    List<Campanha> findAll();

    List<Campanha> buscarCampanhaPorNome(String nomeCampanha);

    List<Campanha> buscarCampanhaPorCriador(String idUsuario);

}
