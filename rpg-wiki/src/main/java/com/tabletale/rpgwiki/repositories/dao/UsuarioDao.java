package com.tabletale.rpgwiki.repositories.dao;

import com.tabletale.rpgwiki.domain.entity.Usuario;

import java.util.List;

public interface UsuarioDao {

    void save(Usuario usuario);

    void update(Usuario usuario);

    void delete(String id);

    Usuario findById(String id);

    List<Usuario> findAll();

    List<Usuario> findByName(String nome);

    String findByEmail(String email);

}
