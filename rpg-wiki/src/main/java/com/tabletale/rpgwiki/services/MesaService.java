package com.tabletale.rpgwiki.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tabletale.rpgwiki.domain.entity.Mesa;
import com.tabletale.rpgwiki.repositories.MesaRepository;


@Service
public class MesaService {
    @Autowired
    private MesaRepository mesaRepository;

    public List<Mesa> buscarTodos() {
        return mesaRepository.findAll();
    }

    public Mesa buscarPorId(String id) {
        return mesaRepository.findById(id).orElse(null);
    }

    public List<Mesa> buscarMesa(String nomeDoJogo) {
        return mesaRepository.findByNomeDoJogo(nomeDoJogo);
    }

    public Mesa criarMesa(Mesa objeto) {
        Mesa objetoNovo = mesaRepository.saveAndFlush(objeto);
        return objetoNovo;
    }

    public Mesa alterar(Mesa objeto) {
        return mesaRepository.saveAndFlush(objeto);
    }

    public void excluir(String id) {
        Mesa objeto = mesaRepository.findById(id).get();
        mesaRepository.delete(objeto);
    }
}
