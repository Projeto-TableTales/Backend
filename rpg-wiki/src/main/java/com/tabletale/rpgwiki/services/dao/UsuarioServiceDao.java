package com.tabletale.rpgwiki.services.dao;

import java.util.List;

import com.tabletale.rpgwiki.repositories.dao.UsuarioDaoImpl;
import com.tabletale.rpgwiki.services.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tabletale.rpgwiki.domain.entity.Usuario;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = false)
public class UsuarioServiceDao {

    @Autowired
    private UsuarioDaoImpl repository;

    public void criarUsuario(Usuario usuario) {
        repository.save(usuario);
    }

    public void alterar(Usuario usuario) {
        repository.update(usuario);
    }

    public boolean excluir(String id) {
        if (buscarPorId(id) == null) {
            throw new UserNotFoundException("Usuário não existe");
        }
        repository.delete(id);
        return true;
    }

    @Transactional(readOnly = true)
    public Usuario buscarPorId(String id) {
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
    

