package com.tabletale.rpgwiki.services;

import java.util.List;

import com.tabletale.rpgwiki.repositories.dao.UsuarioDaoImpl;
import com.tabletale.rpgwiki.services.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tabletale.rpgwiki.domain.entity.Usuario;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class UsuarioService {

    @Autowired
    private UsuarioDaoImpl repositoryUsuario;

    public Usuario buscarPorId(String id) {
        if (repositoryUsuario.findById(id) == null) {
            throw new UserNotFoundException("Usuário não existe");
        }
        return repositoryUsuario.findById(id);
    }

    public List<Usuario> buscarTodos() {
        return repositoryUsuario.findAll();
    }

    public List<Usuario> buscarUsuario(String nome) {
        if (repositoryUsuario.findByName(nome).isEmpty()) {
            throw new UserNotFoundException("Não há usuários cadastrados com o nome " + nome);
        }
        return repositoryUsuario.findByName(nome);
    }
    
}
    

