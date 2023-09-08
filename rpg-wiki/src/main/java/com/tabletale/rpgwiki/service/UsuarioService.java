package com.tabletale.rpgwiki.service;

import com.tabletale.rpgwiki.domain.Usuario;

import java.util.List;

public interface UsuarioService {

    void salvar(Usuario usuario);

    void editar(Usuario usuario);

    void excluir(String id);

    Usuario buscarPoId(String id);

    List<Usuario> buscarTodos();

}
