package com.tabletale.rpgwiki.dao;

import com.tabletale.rpgwiki.domain.Usuario;

import java.util.List;

public interface UsuarioDao {

    void save(Usuario usuario);

    void update(Usuario usuario);

    void delete(String id);


    Usuario findById(String id);

    List<Usuario> findAll();

}
