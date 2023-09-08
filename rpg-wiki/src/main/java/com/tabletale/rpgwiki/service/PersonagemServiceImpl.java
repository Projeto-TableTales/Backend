package com.tabletale.rpgwiki.service;

import com.tabletale.rpgwiki.dao.PersonagemDao;
import com.tabletale.rpgwiki.domain.Personagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional(readOnly = false)
public class PersonagemServiceImpl implements PersonagemService{

    @Autowired
    private PersonagemDao dao;

    @Override
    public void salvar(Personagem personagem) {
        dao.save(personagem);
    }

    @Override
    public void editar(Personagem personagem) {
        dao.update(personagem);
    }

    @Override
    public void excluir(String id) {
        dao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Personagem buscarPorId(String id) {
        return dao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Personagem> buscarTodos() {
        return dao.findAll();
    }

}
