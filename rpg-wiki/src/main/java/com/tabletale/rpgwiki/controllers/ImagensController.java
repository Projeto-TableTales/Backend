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

import com.tabletale.rpgwiki.domain.entity.Imagem;
import com.tabletale.rpgwiki.services.ImagemService;

@RestController
@RequestMapping("/imagens")
@CrossOrigin
public class ImagensController {

    @Autowired
    private ImagemService imagemService;


    @GetMapping("/findById/{id}")
    public ResponseEntity<Imagem> encontrarImagemPorId(@PathVariable Long idImg) {
        Imagem imagem = imagemService.findPorId(idImg);
        if (imagem != null) {
            return ResponseEntity.ok(imagem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/upImagem")
    public ResponseEntity<Imagem> upImagemPost(@RequestParam("file") MultipartFile file,
            @ModelAttribute Imagem imagem) throws IOException {
        return ResponseEntity.ok().body(imagemService.upImagem(file));
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) throws IOException {
        imagemService.remover(id);
        return ResponseEntity.ok().build();
    }

}