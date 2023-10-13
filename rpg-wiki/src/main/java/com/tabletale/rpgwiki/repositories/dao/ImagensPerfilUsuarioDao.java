package com.tabletale.rpgwiki.repositories.dao;

import com.tabletale.rpgwiki.domain.entity.ImagensPerfilUsuario;

import java.util.List;

public interface ImagensPerfilUsuarioDao {

    void save(ImagensPerfilUsuario imagensPerfilUsuario);

    void update(ImagensPerfilUsuario imagensPerfilUsuario);

    void delete(Long id);

    ImagensPerfilUsuario findById(Long id);

    List<ImagensPerfilUsuario> findAll();

}
