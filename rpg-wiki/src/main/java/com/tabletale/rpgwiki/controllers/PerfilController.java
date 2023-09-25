package com.tabletale.rpgwiki.controllers;

import com.tabletale.rpgwiki.services.dao.PerfilServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfil")
@CrossOrigin("*")
public class PerfilController {

    @Autowired
    private PerfilServiceDao perfilService;


    //-------------- Funções relacionadas a informações básicas do Usuario -----------------//
    @GetMapping("/name/{id}")
    public ResponseEntity<String> getName(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(perfilService.getName(id));
    }

    @GetMapping("/biografia/{id}")
    public ResponseEntity<String> getBiografia(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(perfilService.getBiografia(id));
    }

    @PutMapping("/editarbiografia/{id}")
    public ResponseEntity<String> alterarBiografia(@PathVariable("id") String id, @RequestParam("novaBiografia") String novaBiografia) {
        return ResponseEntity.ok().body(perfilService.alterarBiografia(id, novaBiografia));
    }

    @GetMapping("/pais/{id}")
    public ResponseEntity<String> getPais(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(perfilService.getPais(id));
    }

    //----------------- Funções relacionadas aos Links de Redes Sociais do Usuario ----------------//
    @GetMapping("/usernameinstagram/{id}")
    public ResponseEntity<String> getUsernameInstagram(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(perfilService.getUsernameInstagram(id));
    }

    @PutMapping("/editarusernameinstagram/{id}")
    public ResponseEntity<String> alterarUsernameInstagram(@PathVariable("id") String id, @RequestParam("novoUsername") String novoUsername) {
        return ResponseEntity.ok().body(perfilService.alterarUsernameInstagram(id, novoUsername));
    }

    @GetMapping("/usernamefacebook/{id}")
    public ResponseEntity<String> getUsernameFacebook(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(perfilService.getUsernameFacebook(id));
    }

    @PutMapping("/editarusernamefacebook/{id}")
    public ResponseEntity<String> alterarUsernameFacebook(@PathVariable("id") String id, @RequestParam("novoUsername") String novoUsername) {
        return ResponseEntity.ok().body(perfilService.alterarUsernameFacebook(id, novoUsername));
    }

    @GetMapping("/usernametwitter/{id}")
    public ResponseEntity<String> getUsernameTwitter(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(perfilService.getUsernameTwitter(id));
    }

    @PutMapping("/editarusernametwitter/{id}")
    public ResponseEntity<String> alterarUsernameTwitter(@PathVariable("id") String id, @RequestParam("novoUsername") String novoUsername) {
        return ResponseEntity.ok().body(perfilService.alterarUsernameTwitter(id, novoUsername));
    }

    //------------------- Funções relacionadas a lista de RPGs Favoritos do Usuario -----------------------//
    @GetMapping("/listarpgsfavoritos/{id}")
    public ResponseEntity<List<String>> getRPGSfavoritos(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(perfilService.getRPGSfavoritos(id));
    }

    //Necessário ainda trabalhar com exeções para caso o nome do RPG passado para ser adicionado já esteja na lista de RPGs do Usuário.
    @PostMapping("/adicionar/{id}")
    public ResponseEntity<List<String>> adicionarRPGSlistaFavoritos(@PathVariable("id") String id, @RequestParam("nomeRPG") String nomeRPG) {
        return ResponseEntity.ok().body(perfilService.adicionarRPGSlistaFavoritos(id, nomeRPG));
    }

    //Necessário ainda trabalhar com exeções para caso o nome do RPG passado para ser removido não esteja na lista de RPGs do Usuário.
    @DeleteMapping("/remover/{id}")
    public ResponseEntity<List<String>> removerRPGSlistaFavoritos(@PathVariable("id") String id, @RequestParam("nomeRPG") String nomeRPG) {
        return ResponseEntity.ok().body(perfilService.removerRPGSlistaFavoritos(id, nomeRPG));
    }

}
