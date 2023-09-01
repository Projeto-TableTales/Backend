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
@RequestMapping("/personagem")
@CrossOrigin
public class PersonagemController {
    
    @Autowired
    private PersonagemService personagemService;

    @GetMapping("/buscarTodos")
    public List<Personagem> buscarTodos(){
       return personagemService.buscarTodos();
    }

    @GetMapping("/buscarPorNome")
    public ResponseEntity<List<Personagem>> buscarPersonagem(@RequestParam String nome) {
        List<Personagem> personagem = personagemService.buscarPersonagem(nome);

        if (!personagem.isEmpty()) {
            return ResponseEntity.ok(personagem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/criar")
    public Personagem inserir(@RequestBody Personagem objeto){
        return personagemService.criarPersonagem(objeto);
    }

    @PutMapping("/editar")
    public Personagem alterar(@RequestBody Personagem objeto){
        return personagemService.alterar(objeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") String id){
        personagemService.excluir(id);
        return ResponseEntity.ok().build();
    }

}