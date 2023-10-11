package com.tabletale.rpgwiki.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tabletale.rpgwiki.domain.dto.PostDTO;
import com.tabletale.rpgwiki.domain.entity.Post;
import com.tabletale.rpgwiki.repositories.PostRepository;
import com.tabletale.rpgwiki.services.PostService;


@RestController
@RequestMapping("/post")
@CrossOrigin("*")
public class PostController {
    
    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/buscarAll")
    public List<Post> buscarAllPosts() throws Exception{
       return postService.buscarTodos();
    }

    @GetMapping("/buscarByTitulo{id}")
    public List<Post> buscarByTitulo(@PathVariable("titulo") String titulo) throws Exception{
       return postService.buscarByTitulo(titulo);
    }

    @PostMapping("/criarPost")
    public ResponseEntity<Post> criarPost(@RequestBody PostDTO data){
        Post newPost = new Post(data.titulo(), data.conteudo(), data.dataPost());
        Post postResp = this.postRepository.saveAndFlush(newPost);
        return ResponseEntity.ok(postResp);
    }

    @PutMapping("/editarPost")
    public Post alterar(@RequestBody Post objeto){
        return postService.editarPost(objeto);
    }

    @DeleteMapping("/excluirPost/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") String id){
        postService.excluir(id);
        return ResponseEntity.ok().build();
    }
}