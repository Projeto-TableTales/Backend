package com.tabletale.rpgwiki.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tabletale.rpgwiki.domain.entity.Personagem;
import com.tabletale.rpgwiki.repositories.PersonagemRepository;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    public List<Personagem> buscarTodos() {
        return personagemRepository.findAll();
    }

    public Personagem buscarPorId(String id) {
        return personagemRepository.findById(id).orElse(null);
    }

    public List<Personagem> buscarPorNome(String nome) {
        return personagemRepository.findByNome(nome);
    }


    public Personagem criarPersonagem(Personagem objeto) {
        objeto.setDataCriacao(new Date());
        Personagem objetoNovo = personagemRepository.saveAndFlush(objeto);
        return objetoNovo;
    }

    public void excluir(String id) {
        Personagem objeto = personagemRepository.findById(id).get();
        personagemRepository.delete(objeto);
    }

}