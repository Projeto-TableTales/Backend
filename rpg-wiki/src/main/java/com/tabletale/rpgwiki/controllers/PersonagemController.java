package com.tabletale.rpgwiki.controllers;

import java.util.List;


import com.tabletale.rpgwiki.domain.dto.RegisterDTO;
import com.tabletale.rpgwiki.domain.dto.RegisterPersonagemDTO;
import com.tabletale.rpgwiki.services.PersonagemService;
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


@RestController
@RequestMapping("/personagem")
@CrossOrigin("*")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @PostMapping("/criar/{id}")
    public void criarPersonagem(@PathVariable("id") String id, @RequestBody RegisterPersonagemDTO personagemDTO){
        Personagem personagem = new Personagem(personagemDTO.nome(), personagemDTO.idade(), personagemDTO.status(), personagemDTO.sistema(), personagemDTO.descricao(), personagemDTO.personalidade(), personagemDTO.tagsPersonagem(), personagemDTO.historia());
        personagemService.criarPersonagem(id, personagem);
    }

    @GetMapping("/buscarTodos/{id}")
    public List<Personagem> buscarTodosPersonagens(@PathVariable("id") String id){
        return personagemService.buscarTodosPersonagensDoUsuario(id);
    }

}