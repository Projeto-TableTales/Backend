package com.tabletale.rpgwiki.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tabletale.rpgwiki.domain.entity.Imagens;
import com.tabletale.rpgwiki.services.ImagensService;



@RestController
@RequestMapping("/imagens")
@CrossOrigin
public class ImagensController {
    
    @Autowired
    private ImagensService imagensService;

    @GetMapping("/")
    public List<Imagens> buscarTodos(){
       return imagensService.buscarTodos();
    }

    @PostMapping("/inserir")
    public Imagens inserir( @RequestParam("file") MultipartFile file){
        return imagensService.inserir(file);
    }


    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        imagensService.remover(id);
        return ResponseEntity.ok().build();
    }

}