package com.tabletale.rpgwiki.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tabletale.rpgwiki.domain.entity.Post;

import com.tabletale.rpgwiki.repositories.dao.PostDaoImpl;

import jakarta.transaction.Transactional;

@Service
public class PostService {

    @Autowired
    private PostDaoImpl postRepository;

    public List<Post> buscarTodos() throws Exception {
        if (postRepository.findAll().isEmpty()) 
             new Exception("Você ainda não postou nada!");
        
        return postRepository.findAll();
    }

    public List<Post> buscarByTitulo(String titulo) throws Exception {
        if (postRepository.findByTitulo(titulo).isEmpty())
            new Exception("Título não encontrado!");

        return postRepository.findByTitulo(titulo);

    }
    
    @Transactional
    public String criarPost(Post objeto) {
        objeto.setDataPost(new Date());
        postRepository.save(objeto);
        return "Postado!";

    }

    public String editarPost(Post objeto) {
        objeto.setDataEdicao(new Date());
        postRepository.update(objeto);
        return ("Editado!");
    }

    public void excluir(String id) {
        postRepository.delete(id);
    }

}
