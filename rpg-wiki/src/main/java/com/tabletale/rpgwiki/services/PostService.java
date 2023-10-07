package com.tabletale.rpgwiki.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tabletale.rpgwiki.domain.entity.Post;
import com.tabletale.rpgwiki.repositories.PostRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> buscarTodos() {
        return postRepository.findAll();
    }

    public List<Post> buscarByTitulo(String titulo) {
        return postRepository.findByTitulo(titulo);
      
    }

    public void criarPost(Post objeto) {
        objeto.setDataPost(new Date());
        postRepository.saveAndFlush(objeto);
         
    }

    public Post editarPost(Post objeto) {
        objeto.setDataEdicao(new Date());
        return postRepository.saveAndFlush(objeto);
    }

    public void excluir(Long id) {
        Post objeto = postRepository.findById(id).get();
        postRepository.delete(objeto);
    }
}
