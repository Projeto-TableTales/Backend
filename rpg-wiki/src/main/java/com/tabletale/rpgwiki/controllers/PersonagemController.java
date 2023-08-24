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

import com.tabletale.rpgwiki.domain.entity.Personagem;
import com.tabletale.rpgwiki.services.PersonagemService;



@RestController
@RequestMapping("/api/Personagem")
@CrossOrigin
public class PersonagemController {
    
    @Autowired
    private PersonagemService personagemService;

    @GetMapping("/")
    public List<Personagem> buscarTodos(){
       return personagemService.buscarTodos();
    }

    @GetMapping("/buscarUser")
    public ResponseEntity<List<Personagem>> buscarPersonagem(@RequestParam String nome) {
        List<Personagem> produtos = personagemService.buscarPersonagem(nome);

        if (!produtos.isEmpty()) {
            return ResponseEntity.ok(produtos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/")
    public Personagem inserir(@RequestBody Personagem objeto){
        return personagemService.criarPersonagem(objeto);
    }

    @PutMapping("/")
    public Personagem alterar(@RequestBody Personagem objeto){
        return personagemService.alterar(objeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") String id){
        personagemService.excluir(id);
        return ResponseEntity.ok().build();
    }

}