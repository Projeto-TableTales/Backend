package com.tabletale.rpgwiki.repositories.dao;

import java.util.List;

import com.tabletale.rpgwiki.domain.entity.Comentario;

public interface ComentarioDao {
    
    void save(Comentario comentario);

    void update(Comentario comentario);

    void delete(String id);

    Comentario findById(String id);

    List<Comentario> findAll();
}
