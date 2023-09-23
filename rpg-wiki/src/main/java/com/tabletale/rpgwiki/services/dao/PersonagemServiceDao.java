package com.tabletale.rpgwiki.services.dao;

import java.util.List;

import com.tabletale.rpgwiki.repositories.dao.PersonagemDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tabletale.rpgwiki.domain.entity.Personagem;

@Service
@Transactional(readOnly = false)
public class PersonagemServiceDao {

    @Autowired
    private PersonagemDaoImpl repository;

    public void criarPersonagem(Personagem personagem) {
       repository.save(personagem);
    }

    public void alterar(Personagem personagem){
        repository.update(personagem);
    }

    public void excluir(String id) {
        repository.delete(id);
    }

    @Transactional(readOnly = true)
    public Personagem buscarPorId(String id) {
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Personagem> buscarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Personagem> buscarPersonagem(String nome) {
        return repository.findByName(nome);
    }

}