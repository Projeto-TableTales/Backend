package com.tabletale.rpgwiki.service;

import com.tabletale.rpgwiki.domain.Personagem;

import java.util.List;

public interface PersonagemService {

    void salvar(Personagem personagem);

    void editar(Personagem personagem);

    void excluir(String id);

    Personagem buscarPorId(String id);

    List<Personagem> buscarTodos();

}
