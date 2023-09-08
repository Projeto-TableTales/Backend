package com.tabletale.rpgwiki.service;

import com.tabletale.rpgwiki.dao.MesaDao;
import com.tabletale.rpgwiki.domain.Mesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional(readOnly = false)
public class MesaServiceImpl implements MesaService{

    @Autowired
    private MesaDao dao;

    @Override
    public void salvar(Mesa mesa) {
        dao.save(mesa);
    }

    @Override
    public void editar(Mesa mesa) {
        dao.update(mesa);
    }

    @Override
    public void excluir(String id) {
        dao.delete(id);
    }

    @Override
    public Mesa buscarPorId(String id) {
        return dao.findById(id);
    }

    @Override
    public List<Mesa> buscarTodos() {
        return dao.findAll();
    }

}
