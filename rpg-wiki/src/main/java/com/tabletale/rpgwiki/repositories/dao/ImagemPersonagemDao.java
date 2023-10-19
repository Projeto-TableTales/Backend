package com.tabletale.rpgwiki.repositories.dao;

import com.tabletale.rpgwiki.domain.entity.ImagemPersonagem;

import java.util.List;

public interface ImagemPersonagemDao {

    void save(ImagemPersonagem imagensPersonagens);

    void update(ImagemPersonagem imagensPersonagens);

    void delete(Long id);

    ImagemPersonagem findById(Long id);

    List<ImagemPersonagem> findAll();

    ImagemPersonagem buscarImagemPersonagem(String idPersonagem);

}
