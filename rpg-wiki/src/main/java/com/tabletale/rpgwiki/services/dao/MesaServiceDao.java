package com.tabletale.rpgwiki.services.dao;

import java.util.List;

import com.tabletale.rpgwiki.repositories.dao.MesaDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tabletale.rpgwiki.domain.entity.Mesa;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = false)
public class MesaServiceDao {
    @Autowired
    private MesaDaoImpl repository;

    public void criarMesa(Mesa mesa) {
        repository.save(mesa);
    }

    public void alterar(Mesa mesa) {
        repository.update(mesa);
    }

    public void excluir(String id) {
        repository.delete(id);
    }

    @Transactional(readOnly = true)
    public Mesa buscarPorId(String id) {
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Mesa> buscarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Mesa> buscarMesa(String nomeDoJogo) {
        return repository.findByNameOfGame(nomeDoJogo);
    }

}
