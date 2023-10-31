package com.tabletale.rpgwiki.controllers;


import com.tabletale.rpgwiki.domain.dto.RegisterPersonagemDTO;
import com.tabletale.rpgwiki.services.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tabletale.rpgwiki.domain.entity.Personagem;



@RestController
@RequestMapping("/personagem")
@CrossOrigin("*")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    //---------------------------------------------------------------------------------------------------------------------//
    @PostMapping("/criar/{id}")
    public ResponseEntity<?> criarPersonagem(@PathVariable("id") String id, @RequestBody RegisterPersonagemDTO personagemDTO){
        Personagem personagem = new Personagem(personagemDTO.nome(), personagemDTO.idade(), personagemDTO.status(), personagemDTO.sistema(), 
        personagemDTO.descricao(), personagemDTO.personalidade(), personagemDTO.historia());
        return ResponseEntity.ok().body(personagemService.criarPersonagem(id, personagem));
    }

    public ResponseEntity<?> excluirPersonagem(@PathVariable("id") String id, @RequestParam("idPersonagem") String idPersonagem) {
        return ResponseEntity.ok().body(personagemService.excluirPersonagem(id, idPersonagem));
    }

    @GetMapping("/buscarTodos/{id}")
    public ResponseEntity<?> buscarTodosPersonagens(@PathVariable("id") String id){
        return ResponseEntity.ok().body(personagemService.buscarTodosPersonagensDoUsuario(id));
    }
    
}