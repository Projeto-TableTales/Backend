package com.tabletale.rpgwiki.repositories.Imagens;

import java.util.List;

import com.tabletale.rpgwiki.domain.entity.entity_imagens.ImagemPersonagem;

public interface ImagemPersonagemDao {

    void save(ImagemPersonagem imagensPersonagens);

    void update(ImagemPersonagem imagensPersonagens);

    void delete(Long id);

    ImagemPersonagem findById(Long id);

    List<ImagemPersonagem> findAll();

    ImagemPersonagem buscarImagemPersonagem(String idPersonagem);

}
