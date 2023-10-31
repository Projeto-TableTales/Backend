package com.tabletale.rpgwiki.controllers;


import com.tabletale.rpgwiki.domain.dto.RegisterPersonagemDTO;
import com.tabletale.rpgwiki.services.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.tabletale.rpgwiki.domain.entity.Personagem;



@RestController
@RequestMapping("/personagem")
@CrossOrigin("*")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    //---------------------------------------------------------------------------------------------------------------------//
    @PostMapping()
    public ResponseEntity<?> criarPersonagem(Authentication auth, @RequestBody RegisterPersonagemDTO personagemDTO){
        Personagem personagem = new Personagem(personagemDTO.nome(), personagemDTO.idade(), personagemDTO.status(), personagemDTO.sistema(),
        personagemDTO.descricao(), personagemDTO.personalidade(), personagemDTO.historia());
        return ResponseEntity.ok().body(personagemService.criarPersonagem(auth.getPrincipal().toString(), personagem));
    }

    @DeleteMapping()
    public ResponseEntity<?> excluirPersonagem(Authentication auth, @RequestParam("idPersonagem") String idPersonagem) {
        return ResponseEntity.ok().body(personagemService.excluirPersonagem(auth.getPrincipal().toString(), idPersonagem));
    }

    @GetMapping()
    public ResponseEntity<?> buscarTodosPersonagens(Authentication auth){
        return ResponseEntity.ok().body(personagemService.buscarTodosPersonagensDoUsuario(auth.getPrincipal().toString()));
    }
    
}