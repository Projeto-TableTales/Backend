package com.tabletale.rpgwiki.service;

import com.tabletale.rpgwiki.domain.Mesa;

import java.util.List;

public interface MesaService {

    void salvar(Mesa mesa);

    void editar(Mesa mesa);

    void excluir(Long id);

    Mesa buscarPorId(Long id);

    List<Mesa> buscarTodos();

}
