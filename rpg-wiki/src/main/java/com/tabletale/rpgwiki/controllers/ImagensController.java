package com.tabletale.rpgwiki.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tabletale.rpgwiki.services.ImagemService;


@RestController
@RequestMapping("/imagens")
@CrossOrigin
public class ImagensController {

   
    @Autowired
    private ImagemService imagemService;

    
    @PostMapping("/adicionarImagemPost/{id}")
    public void adicionarImagem(@PathVariable("id") String id, @RequestParam("file") MultipartFile file) {
        imagemService.inserirImagemPost(file, id);
    }

    // // @GetMapping("/")
    // // public List<AbstractImagens> buscarTodos(){
    // //    return imagensService.buscarTodos();
    // // }

    // @PostMapping("/inserir")
    // public AbstractImagens inserir(@RequestParam("file") MultipartFile file){
    //     return imagensService.inserir(file);
    // }


    // // @DeleteMapping("/remover/{id}")
    // // public ResponseEntity<Void> remover(@PathVariable Long id){
    // //     imagensService.remover(id);
    // //     return ResponseEntity.ok().build();
    // // }


}