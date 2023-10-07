package com.tabletale.rpgwiki.services;

import java.util.List;

import com.tabletale.rpgwiki.repositories.dao.UsuarioDaoImpl;
import com.tabletale.rpgwiki.services.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tabletale.rpgwiki.domain.entity.Usuario;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = false)
public class UsuarioService {

    @Autowired
    private UsuarioDaoImpl repository;

    @Transactional(readOnly = true)
    public Usuario buscarPorId(String id) {
        if (repository.findById(id) == null) {
            throw new UserNotFoundException("Usuário não existe");
        }
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Usuario> buscarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Usuario> buscarUsuario(String nome) {
        if (repository.findByName(nome).isEmpty()) {
            throw new UserNotFoundException("Não há usuários cadastrados com o nome " + nome);
        }
        return repository.findByName(nome);
    }
    
}
    

