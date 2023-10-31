package com.tabletale.rpgwiki.controllers;

import com.tabletale.rpgwiki.domain.dto.RegisterCampanhaDTO;
import com.tabletale.rpgwiki.domain.entity.Campanha;
import com.tabletale.rpgwiki.services.CampanhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campanha")
@CrossOrigin("*")
public class CampanhaController {

    @Autowired
    private CampanhaService serviceCampanha;

    @PostMapping("/criar/{id}")
    public void criarCampanha(@PathVariable("id") String id, @RequestBody RegisterCampanhaDTO campanhaDTO) {
        Campanha campanha = new Campanha(campanhaDTO.nome());
        serviceCampanha.criarCampanha(campanha, id);
    }

    @GetMapping("/buscarcampanhas")
    public List<Campanha> buscarCampanhas() {
        return serviceCampanha.buscarCampanhas();
    }

    @GetMapping("/buscarcampanhapornome")
    public ResponseEntity<?> buscarCampanhasPorNome(@RequestParam("nomeCampanha") String nomeCampanha) {
        return ResponseEntity.ok().body(serviceCampanha.buscarCampanhaPorNome(nomeCampanha));
    }

    @GetMapping("/buscarcampanhadocirador/{id}")
    public ResponseEntity<?> buscarCampanhasPorCriador(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(serviceCampanha.buscarCampanhaPorCriador(id));
    }

    @PostMapping("/seguircampanha/{id}")
    public void seguirCampanha(@PathVariable("id") String id, @RequestParam("idCampanha") String idCampanha) {
        serviceCampanha.seguirCampanha(idCampanha, id);
    }

    @PutMapping("/saircampanha/{id}")
    public void sairCampanha(@PathVariable("id") String id, @RequestParam("idCampanha") String idCampanha) {
        serviceCampanha.sairCampanha(idCampanha, id);
    }

    @GetMapping("/buscarcampanhaseguidas/{id}")
    public List<Campanha> buscarCampanhasSeguidas(@PathVariable("id") String id) {
        return serviceCampanha.buscarCampanhaSeguida(id);
    }

}
