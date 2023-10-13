package com.tabletale.rpgwiki.repositories.dao;

import com.tabletale.rpgwiki.domain.entity.ImagensPerfilUsuario;
import com.tabletale.rpgwiki.domain.entity.ImagensPersonagens;
import com.tabletale.rpgwiki.domain.entity.Mesa;

import java.util.List;

public interface ImagensPersonagensDao {

    void save(ImagensPersonagens imagensPersonagens);

    void update(ImagensPersonagens imagensPersonagens);

    void delete(Long id);

    ImagensPersonagens findById(Long id);

    List<ImagensPersonagens> findAll();

}
