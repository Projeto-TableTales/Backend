package com.tabletale.rpgwiki.service;

import com.tabletale.rpgwiki.dao.UsuarioDao;
import com.tabletale.rpgwiki.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional(readOnly = false)
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioDao dao;

    @Override
    public void salvar(Usuario usuario) {
        dao.save(usuario);
    }

    @Override
    public void editar(Usuario usuario) {
        dao.update(usuario);
    }

    @Override
    public void excluir(String id) {
        dao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario buscarPoId(String id) {
        return dao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> buscarTodos() {
        return dao.findAll();
    }

}
