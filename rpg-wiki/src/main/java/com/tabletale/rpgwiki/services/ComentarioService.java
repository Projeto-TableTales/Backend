package com.tabletale.rpgwiki.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tabletale.rpgwiki.domain.entity.Comentario;
import com.tabletale.rpgwiki.repositories.dao.ComentarioDao;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioDao comentarioRepository;

    public List<Comentario> buscarTodos() throws Exception {
        if (comentarioRepository.findAll().isEmpty())
            new Exception("Não a comentario nessa postagem!");

        return comentarioRepository.findAll();
    }

    public void criarComentario(Comentario objeto) {
        objeto.setDataComentario(new Date());
        comentarioRepository.save(objeto);

    }

    public String excluir(String id) {
        comentarioRepository.delete(id);
        return "Comentario excluido!";
    }
}
