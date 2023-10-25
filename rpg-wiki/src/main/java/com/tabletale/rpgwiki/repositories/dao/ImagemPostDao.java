package com.tabletale.rpgwiki.repositories.dao;

import com.tabletale.rpgwiki.domain.entity.ImagemPost;

import java.util.List;

public interface ImagemPostDao {

    void save(ImagemPost imagensPost);

    void update(ImagemPost imagensPost);

    void delete(Long id);

    ImagemPost findById(Long id);

    List<ImagemPost> findAll();

    ImagemPost buscarImagemPost(String idPost);

}
