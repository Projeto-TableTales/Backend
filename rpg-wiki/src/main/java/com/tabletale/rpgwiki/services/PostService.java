package com.tabletale.rpgwiki.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tabletale.rpgwiki.domain.entity.Post;
import com.tabletale.rpgwiki.domain.entity.Usuario;
import com.tabletale.rpgwiki.repositories.dao.PostDaoImpl;
import com.tabletale.rpgwiki.repositories.dao.UsuarioDao;
import com.tabletale.rpgwiki.services.exceptions.PersonagemNotFoundException;
import com.tabletale.rpgwiki.services.exceptions.UserNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class PostService {

    @Autowired
    private PostDaoImpl postRepository;
    @Autowired
    private UsuarioDao usuarioDao;



    public List<Post> buscarTodos(String idUser) throws Exception {
        if (postRepository.buscarAllPost(idUser).isEmpty()) {
            throw new PersonagemNotFoundException("Usuário ainda não postou nada");
        }
        
        return postRepository.buscarAllPost(idUser);
    }

    public List<Post> byTitulo(String titulo) throws Exception {
        return postRepository.findByTitulo(titulo);

    }

    @Transactional
    public String criarPost(String idUsuario, Post objeto) {
        if (usuarioDao.findById(idUsuario) == null) {
            throw new UserNotFoundException("Usuário não encontrado");
        }
        Usuario usuario = usuarioDao.findById(idUsuario);
        objeto.setUsuario(usuario);
        objeto.setDataPost(new Date());
        postRepository.save(objeto);
        usuarioDao.update(usuario);
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
