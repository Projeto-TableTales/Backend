package com.tabletale.rpgwiki.service;

import com.tabletale.rpgwiki.domain.Usuario;

import java.util.List;

public interface UsuarioService {

    void salvar(Usuario usuario);

    void editar(Usuario usuario);

    void excluir(Long id);

    Usuario buscarPoId(Long id);

    List<Usuario> buscarTodos();

}
