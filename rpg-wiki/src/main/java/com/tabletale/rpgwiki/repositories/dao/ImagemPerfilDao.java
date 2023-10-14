package com.tabletale.rpgwiki.repositories.dao;

import com.tabletale.rpgwiki.domain.entity.ImagemPerfil;

import java.util.List;

public interface ImagemPerfilDao {

    void save(ImagemPerfil imagensPerfilUsuario);

    void update(ImagemPerfil imagensPerfilUsuario);

    void delete(Long id);

    ImagemPerfil findById(Long id);

    List<ImagemPerfil> findAll();

    ImagemPerfil buscarImagemPerfilUsuario(String idUsuario);

}
