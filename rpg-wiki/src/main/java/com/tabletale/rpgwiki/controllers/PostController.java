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

import com.tabletale.rpgwiki.repositories.dao.PostDao;
import com.tabletale.rpgwiki.services.PostService;

@RestController
@RequestMapping("/post")
@CrossOrigin("*")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private PostDao postRepository;


    @GetMapping("/buscarAll/{idUser}")
    public List<Post> buscarAllPosts(@PathVariable ("idUser") String idUser) throws Exception {
        return postService.buscarTodos(idUser);
    }

    @GetMapping("/buscarById/{id}")
    public Post buscarById(@PathVariable("id") String postId) throws Exception{
       return postRepository.findById(postId);
    }

    @GetMapping("/buscarByTitulo/{titulo}")
    public List<Post> buscarByTitulo(@PathVariable("titulo") String titulo) throws Exception{
       return postService.byTitulo(titulo);
    }

    @PostMapping("/criarPost/{idUser}")
    public String criarPost(@PathVariable ("idUser") String idUser, @RequestBody Post postagem) {    
       return postService.criarPost(idUser, postagem);
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