package com.tabletale.rpgwiki.controllers;

import com.tabletale.rpgwiki.domain.entity.Imagem;
import com.tabletale.rpgwiki.services.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfil")
@CrossOrigin("*")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping("/img/{id}")
    public ResponseEntity<Imagem> getImgPerfil(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(perfilService.getImgPerfil(id));
    }

    @GetMapping("/img/{id}")
    public ResponseEntity<Imagem> getImgCapa(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(perfilService.getImgCapa(id));
    }

    @GetMapping()
    public ResponseEntity<?> getUusario(Authentication auth) {
        return ResponseEntity.ok().body(perfilService.getUsuario(auth.getPrincipal().toString()));
    }

    @PutMapping()
    public void editarUsuario() {

    }

    @GetMapping("/listarpgsfavoritos")
    public ResponseEntity<List<String>> getRPGSfavoritos(Authentication auth) {
        return ResponseEntity.ok().body(perfilService.getRPGSfavoritos(auth.getPrincipal().toString()));
    }

    @PostMapping("/adicionar")
    public ResponseEntity<List<String>> adicionarRPGSlistaFavoritos(Authentication auth,
            @RequestParam("nomeRPG") String nomeRPG) {
        return ResponseEntity.ok()
                .body(perfilService.adicionarRPGSlistaFavoritos(auth.getPrincipal().toString(), nomeRPG));
    }

    @DeleteMapping("/remover")
    public ResponseEntity<List<String>> removerRPGSlistaFavoritos(Authentication auth,
            @RequestParam("nomeRPG") String nomeRPG) {
        return ResponseEntity.ok()
                .body(perfilService.removerRPGSlistaFavoritos(auth.getPrincipal().toString(), nomeRPG));
    }

}
