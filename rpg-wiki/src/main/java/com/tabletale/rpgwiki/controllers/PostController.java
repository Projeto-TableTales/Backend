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

import com.tabletale.rpgwiki.domain.dto.PostDTO;
import com.tabletale.rpgwiki.domain.entity.Post;
import com.tabletale.rpgwiki.services.PostService;


@RestController
@RequestMapping("/post")
@CrossOrigin("*")
public class PostController {
    
    @Autowired
    private PostService postService;


    @GetMapping("/buscarAll")
    public List<Post> buscarAllPosts() throws Exception{
       return postService.buscarTodos();
    }

    @GetMapping("/buscarByTitulo{id}")
    public List<Post> buscarByTitulo(@PathVariable("titulo") String titulo) throws Exception{
       return postService.buscarByTitulo(titulo);
    }


    @GetMapping("/likes")
    public ResponseEntity<?> getLikesPost(@RequestParam("idPost") String idPost) {
        return ResponseEntity.ok().body(postService.getLikesPost(idPost));
    }

    // @PostMapping("/{postId}/like")
    // public ResponseEntity<?> likePost(@PathVariable String postId) {
    //     Optional<Post> postOptional = postRepository.findById(postId);
     
    //         Post post = postOptional.get();
    //         post.setCurtidas(post.getCurtidas() + 1);
    //         postRepository.save(post);
    //         return ResponseEntity.ok().build();
    
    // }

    @PostMapping("/criarPost")
    public ResponseEntity<?> criarPost(@RequestBody PostDTO data){
        Post newPost = new Post(data.titulo(), data.conteudo(), data.dataPost());
        return ResponseEntity.ok().body(postService.criarPost(newPost));
    }

    @PutMapping("/editarPost")
    public ResponseEntity<?> alterar(@RequestParam("idPost") Post idPost){
        return ResponseEntity.ok().body(postService.editarPost(idPost));
    }

    @DeleteMapping("/excluirPost/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") String id){
        postService.excluir(id);
        return ResponseEntity.ok().build();
    }
}