package com.tabletale.rpgwiki.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/imagens")
@CrossOrigin
public class ImagensController {

    /**
    @Autowired
    private ImagensService imagensService;

    @GetMapping("/")
    public List<AbstractImagens> buscarTodos(){
       return imagensService.buscarTodos();
    }

    @PostMapping("/inserir")
    public AbstractImagens inserir(@RequestParam("file") MultipartFile file){
        return imagensService.inserir(file);
    }


    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        imagensService.remover(id);
        return ResponseEntity.ok().build();
    }
    */

}