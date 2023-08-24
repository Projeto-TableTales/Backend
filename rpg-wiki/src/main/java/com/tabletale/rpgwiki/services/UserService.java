package com.tabletale.rpgwiki.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tabletale.rpgwiki.domain.entity.Usuario;
import com.tabletale.rpgwiki.repositories.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Usuario> buscarTodos() {
        return userRepository.findAll();
    }
    
    public Usuario buscarPorId(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<Usuario> buscarUsuario(String nome) {
        return userRepository.findByNome(nome);
    }

    public Usuario criarUsuario(Usuario objeto) {
        Usuario objetoNovo = userRepository.saveAndFlush(objeto);
        return objetoNovo;
    }

    public Usuario alterar(Usuario objeto) {
        return userRepository.saveAndFlush(objeto);
    }

    public void excluir(String id) {
        Usuario objeto = userRepository.findById(id).get();
        userRepository.delete(objeto);
    }
    
}
    

