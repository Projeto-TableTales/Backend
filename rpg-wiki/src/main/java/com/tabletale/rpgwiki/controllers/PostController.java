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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tabletale.rpgwiki.domain.entity.Post;
import com.tabletale.rpgwiki.services.PostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/post")
@CrossOrigin("*")
public class PostController {

    @Autowired
    private PostService postService;


    @GetMapping("/buscarAll")
    public List<Post> buscarAllPosts() throws Exception {
        return postService.buscarTodos();
    }

    @GetMapping("/buscarByTitulo{id}")
    public List<Post> buscarByTitulo(@PathVariable("titulo") String titulo) throws Exception{
       return postService.buscarByTitulo(titulo);
    }

    @PostMapping("/criarPost")
    public String criarPost(@Valid @RequestBody Post postagem) {
        return postService.criarPost(postagem);
    }

    @PutMapping("/editarPost")
    public ResponseEntity<?> alterar(@RequestParam("idPost") Post idPost) {
        return ResponseEntity.ok().body(postService.editarPost(idPost));
    }

    @DeleteMapping("/excluirPost/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") String id) {
        postService.excluir(id);
        return ResponseEntity.ok().build();
    }

    // @PostMapping("/curtir/{postagemId}")
    // public ResponseEntity<?> curtirPostagem(@PathVariable String postagemId, @AuthenticationPrincipal Usuario usuario)
    //         throws Exception {
    //     curtidaService.curtirPost(postagemId, usuario);
    //     return ResponseEntity.ok("Post curtido!");
    // }

}