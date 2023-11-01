package com.tabletale.rpgwiki.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tabletale.rpgwiki.domain.entity.Campanha;
import com.tabletale.rpgwiki.domain.entity.Imagem;
import com.tabletale.rpgwiki.domain.entity.Post;
import com.tabletale.rpgwiki.domain.entity.Usuario;
import com.tabletale.rpgwiki.repositories.dao.CampanhaDao;
import com.tabletale.rpgwiki.repositories.dao.PostDao;
import com.tabletale.rpgwiki.repositories.dao.UsuarioDao;
import com.tabletale.rpgwiki.services.ImagemService;

@RestController
@RequestMapping("/imagens")
@CrossOrigin
public class ImagensController {

    @Autowired
    private ImagemService imagemService;

    @Autowired
    private PostDao postRepository;
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private CampanhaDao campanhaDao;

    @GetMapping("/findById/{id}")
    public ResponseEntity<Imagem> encontrarImagemPorId(@PathVariable Long id) {
        Imagem imagem = imagemService.findPorId(id);
        if (imagem != null) {
            return ResponseEntity.ok(imagem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/upImagemPost/{postId}")
    public ResponseEntity<Imagem> upImagemPost(@PathVariable String postId, @RequestParam("file") MultipartFile file,
            @ModelAttribute Imagem imagem) {
        Post postagem = postRepository.findById(postId);
        imagem.setImgPostagem(postagem);
        imagemService.upImagemPost(postId, file);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/upImagemPerfil/{idUser}")
    public ResponseEntity<Imagem> upImagemPerfil(@PathVariable String idUsuario,
            @RequestParam("file") MultipartFile file, @ModelAttribute Imagem imagem) {
        Usuario usuario = usuarioDao.findById(idUsuario);
        imagem.setImgPerfil(usuario);
        imagemService.upImagemPerfil(idUsuario, file);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/upImagemCapa/{idUser}")
    public ResponseEntity<Imagem> upImagemCapa(@PathVariable String idUsuario,
            @RequestParam("file") MultipartFile file, @ModelAttribute Imagem imagem) {
        Usuario usuario = usuarioDao.findById(idUsuario);
        imagem.setImgCapa(usuario);
        imagemService.upImagemCapa(idUsuario, file);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/upImagemCampanha/{idCampanha}")
    public ResponseEntity<Imagem> upImagemCampanha(@PathVariable String idCampanha,
            @RequestParam("file") MultipartFile file, @ModelAttribute Imagem imagem) {
        Campanha campanha = campanhaDao.findById(idCampanha);
        imagem.setImgCampanha(campanha);
        imagemService.upImagemPost(idCampanha, file);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) throws IOException {
        imagemService.remover(id);
        return ResponseEntity.ok().build();
    }

}