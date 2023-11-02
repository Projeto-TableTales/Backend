package com.tabletale.rpgwiki.controllers;

import com.tabletale.rpgwiki.domain.dto.RegisterCampanhaDTO;
import com.tabletale.rpgwiki.domain.entity.Campanha;
import com.tabletale.rpgwiki.services.CampanhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campanha")
@CrossOrigin("*")
public class CampanhaController {

    @Autowired
    private CampanhaService serviceCampanha;

    @PostMapping("/criar")
    public void criarCampanha(Authentication auth, @RequestBody RegisterCampanhaDTO campanhaDTO) {
        Campanha campanha = new Campanha(campanhaDTO.nome());
        serviceCampanha.criarCampanha(campanha, auth.getPrincipal().toString());
    }

    @GetMapping("/buscarcampanhas")
    public List<Campanha> buscarCampanhas() {
        return serviceCampanha.buscarCampanhas();
    }

    @GetMapping("/buscarcampanhapornome")
    public ResponseEntity<?> buscarCampanhasPorNome(@RequestParam("nomeCampanha") String nomeCampanha) {
        return ResponseEntity.ok().body(serviceCampanha.buscarCampanhaPorNome(nomeCampanha));
    }

    @GetMapping("/buscarcampanhadocirador")
    public ResponseEntity<?> buscarCampanhasPorCriador(Authentication auth) {
        return ResponseEntity.ok().body(serviceCampanha.buscarCampanhaPorCriador(auth.getPrincipal().toString()));
    }

    @PostMapping("/seguircampanha")
    public void seguirCampanha(Authentication auth, @RequestParam("idCampanha") String idCampanha) {
        serviceCampanha.seguirCampanha(idCampanha, auth.getPrincipal().toString());
    }

    @PutMapping("/saircampanha")
    public void deixarSeguirCampanha(Authentication auth, @RequestParam("idCampanha") String idCampanha) {
        serviceCampanha.deixarSeguirCampanha(idCampanha, auth.getPrincipal().toString());
    }

    @GetMapping("/buscarcampanhaseguidas")
    public List<Campanha> buscarCampanhasSeguidas(Authentication auth) {
        return serviceCampanha.buscarCampanhaSeguida(auth.getPrincipal().toString());
    }

    @DeleteMapping("/excluir")
    public ResponseEntity<?> excluirCampanha(Authentication auth, @RequestParam("idCampanha") String idCampanha) {
        return ResponseEntity.ok().body(serviceCampanha.excluirCampanha(idCampanha, auth.getPrincipal().toString()));
    }

}
