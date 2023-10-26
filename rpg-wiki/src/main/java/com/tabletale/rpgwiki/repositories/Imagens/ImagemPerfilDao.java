package com.tabletale.rpgwiki.repositories.Imagens;

import java.util.List;

import com.tabletale.rpgwiki.domain.entity.entity_imagens.ImagemPerfil;

public interface ImagemPerfilDao {

    void save(ImagemPerfil imagensPerfilUsuario);

    void update(ImagemPerfil imagensPerfilUsuario);

    void delete(Long id);

    ImagemPerfil findById(Long id);

    List<ImagemPerfil> findAll();

    ImagemPerfil buscarImagemPerfilUsuario(String idUsuario);

}
