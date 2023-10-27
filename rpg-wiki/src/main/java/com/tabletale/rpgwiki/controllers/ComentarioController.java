package com.tabletale.rpgwiki.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tabletale.rpgwiki.domain.entity.Comentario;
import com.tabletale.rpgwiki.domain.entity.Post;
import com.tabletale.rpgwiki.repositories.ComentarioRepository;
import com.tabletale.rpgwiki.repositories.dao.PostDaoImpl;

@RestController
@RequestMapping("/comentario")
@CrossOrigin("*")
public class ComentarioController {

     @Autowired
     private ComentarioRepository comentarioRepository; 
     @Autowired
     private PostDaoImpl postagemRepository;


     @GetMapping("/comentarios/{postagemId}")
     public List<Comentario> listarComentarios(@PathVariable String postagemId) {
          Post postagem = postagemRepository.findById(postagemId);

          return comentarioRepository.findByPost(postagem);
     }

     @PostMapping("/comentar/{postagemId}")
     public Comentario criarComentario(@PathVariable String postagemId, @RequestBody Comentario comentario) {
          Post postagem = postagemRepository.findById(postagemId);
          comentario.setPost(postagem);
          comentario.setDataComentario(new Date());
          return comentarioRepository.save(comentario);
     }

     @DeleteMapping("/excluirComentario/{id}")
     public void excluir(@PathVariable("id") String id) {
          comentarioRepository.deleteById(id);
     }


}