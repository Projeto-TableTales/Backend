package com.tabletale.rpgwiki.controllers;

import com.tabletale.rpgwiki.services.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfil")
@CrossOrigin("*")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;


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

    @GetMapping("/narrativa/{id}")
    public ResponseEntity<String> getNarrativa(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(perfilService.getNarrativa(id));
    }

    @PutMapping("/editarnarrativa/{id}")
    public ResponseEntity<String> alterarNarrativa(@PathVariable("id") String id, @RequestParam("novaNarrativa") String novaNarrativa) {
        return ResponseEntity.ok().body(perfilService.alterarNarrativa(id, novaNarrativa));
    }

    @GetMapping("/experiencia/{id}")
    public ResponseEntity<String> getExperiencia(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(perfilService.getExperiencia(id));
    }

    @PutMapping("/editarexperiencia/{id}")
    public ResponseEntity<String> alterarExperiencia(@PathVariable("id") String id, @RequestParam("novaExperiencia") String novaExperiencia) {
        return ResponseEntity.ok().body(perfilService.alterarExperiencia(id, novaExperiencia));
    }

    @GetMapping("/tipodejogador/{id}")
    public ResponseEntity<String> getTipoDeJogador(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(perfilService.getTipoDeJogador(id));
    }

    @PutMapping("/editartipodejogador/{id}")
    public ResponseEntity<String> alterarTipoDeJogador(@PathVariable("id") String id, @RequestParam("novoTipoDeJogador") String novoTipoDeJogador) {
        return ResponseEntity.ok().body(perfilService.alterarTipoDeJogador(id, novoTipoDeJogador));
    }

    @GetMapping("/cargo/{id}")
    public ResponseEntity<String> getCargo(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(perfilService.getCargo(id));
    }

    @PutMapping("/editarcargo/{id}")
    public ResponseEntity<String> alterarCargo(@PathVariable("id") String id, @RequestParam("novoCargo") String novoCargo) {
        return ResponseEntity.ok().body(perfilService.alterarCargo(id, novoCargo));
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
