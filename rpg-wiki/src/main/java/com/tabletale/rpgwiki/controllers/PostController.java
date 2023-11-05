package com.tabletale.rpgwiki.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.tabletale.rpgwiki.domain.entity.Curtida;
import com.tabletale.rpgwiki.domain.entity.Post;
import com.tabletale.rpgwiki.domain.entity.Usuario;
import com.tabletale.rpgwiki.repositories.CurtidaRepository;
import com.tabletale.rpgwiki.repositories.dao.PostDao;
import com.tabletale.rpgwiki.repositories.dao.UsuarioDao;

import com.tabletale.rpgwiki.services.PostService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/post")
@CrossOrigin("*")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private PostDao postRepository;
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private CurtidaRepository curtidaRepository;

    @GetMapping("/buscarAll/{idUser}")
    public List<Post> buscarAllPosts(@PathVariable("idUser") String idUser) throws Exception {
        return postService.buscarTodos(idUser);
    }

    @GetMapping("/buscarById/{id}")
    public Post buscarById(@PathVariable("id") String postId) throws Exception {
        return postRepository.findById(postId);
    }

    @GetMapping("/buscarByTitulo/{titulo}")
    public List<Post> buscarByTitulo(@PathVariable("titulo") String titulo) throws Exception {
        return postService.byTitulo(titulo);
    }

    @PostMapping("/criarPost/{idUser}")
    public String criarPost(@PathVariable("idUser") String idUser, @RequestBody Post postagem) {
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
    
    private boolean usuarioJaCurtiuPost(Usuario usuario, Post post) {
        Curtida curtida = curtidaRepository.findByPostagemAndUsuario(post, usuario);
        return curtida != null;
    }
    @PostMapping("/{postId}/{usuarioId}/curtir")
    @Transactional
    public ResponseEntity<String> curtirPost(
            @PathVariable String usuarioId,
            @PathVariable String postId) {

        Usuario usuario = usuarioDao.findById(usuarioId);
        Post post = postRepository.findById(postId);

        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário não encontrado");
        }

        if (post == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post não encontrado");
        }

        if (usuarioJaCurtiuPost(usuario, post)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Você já curtiu este post");
        }

        post.setLikes(post.getLikes() + 1);
        postRepository.save(post);

        Curtida curtida = new Curtida();
        curtida.setUsuario(usuario);
        curtida.setPostagem(post);
        curtidaRepository.save(curtida);

        return ResponseEntity.ok("Post curtido com sucesso!");
    }


    @DeleteMapping("/{postId}/{usuarioId}/descurtir")
    public ResponseEntity<String> descurtirPost(
            @PathVariable String usuarioId,
            @PathVariable String postId) {

        Usuario usuario = usuarioDao.findById(usuarioId);
        Post post = postRepository.findById(postId);

        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário não encontrado");
        }

        if (post == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post não encontrado");
        }

        if (!usuarioJaCurtiuPost(usuario, post)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Você ainda não curtiu este post");
        }

        post.setLikes(post.getLikes() - 1);
        postRepository.save(post);

        Curtida curtida = curtidaRepository.findByPostagemAndUsuario(post, usuario);
        curtidaRepository.delete(curtida);

        return ResponseEntity.ok("Post descurtido com sucesso!");
    }

}
