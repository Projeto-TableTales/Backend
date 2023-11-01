package com.tabletale.rpgwiki.controllers;


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

    
    //-------------- Funções relacionadas a informações básicas do Usuario -----------------//
    @GetMapping("/nome")
    public ResponseEntity<String> getName(Authentication auth) {
        return ResponseEntity.ok().body(perfilService.getName(auth.getPrincipal().toString()));
    }

    @GetMapping("/biografia")
    public ResponseEntity<String> getBiografia(Authentication auth) {
        return ResponseEntity.ok().body(perfilService.getBiografia(auth.getPrincipal().toString()));
    }

    @PutMapping("/editarbiografia")
    public ResponseEntity<String> alterarBiografia(Authentication auth, @RequestParam("novaBiografia") String novaBiografia) {
        return ResponseEntity.ok().body(perfilService.alterarBiografia(auth.getPrincipal().toString(), novaBiografia));
    }

    @GetMapping("/pais")
    public ResponseEntity<String> getPais(Authentication auth) {
        return ResponseEntity.ok().body(perfilService.getPais(auth.getPrincipal().toString()));
    }

    @GetMapping("/narrativa")
    public ResponseEntity<String> getNarrativa(Authentication auth) {
        return ResponseEntity.ok().body(perfilService.getNarrativa(auth.getPrincipal().toString()));
    }

    @PutMapping("/editarnarrativa")
    public ResponseEntity<String> alterarNarrativa(Authentication auth, @RequestParam("novaNarrativa") String novaNarrativa) {
        return ResponseEntity.ok().body(perfilService.alterarNarrativa(auth.getPrincipal().toString(), novaNarrativa));
    }

    @GetMapping("/experiencia")
    public ResponseEntity<String> getExperiencia(Authentication auth) {
        return ResponseEntity.ok().body(perfilService.getExperiencia(auth.getPrincipal().toString()));
    }

    @PutMapping("/editarexperiencia")
    public ResponseEntity<String> alterarExperiencia(Authentication auth, @RequestParam("novaExperiencia") String novaExperiencia) {
        return ResponseEntity.ok().body(perfilService.alterarExperiencia(auth.getPrincipal().toString(), novaExperiencia));
    }

    @GetMapping("/tipodejogador")
    public ResponseEntity<String> getTipoDeJogador(Authentication auth) {
        return ResponseEntity.ok().body(perfilService.getTipoDeJogador(auth.getPrincipal().toString()));
    }

    @PutMapping("/editartipodejogador")
    public ResponseEntity<String> alterarTipoDeJogador(Authentication auth, @RequestParam("novoTipoDeJogador") String novoTipoDeJogador) {
        return ResponseEntity.ok().body(perfilService.alterarTipoDeJogador(auth.getPrincipal().toString(), novoTipoDeJogador));
    }

    @GetMapping("/cargo")
    public ResponseEntity<String> getCargo(Authentication auth) {
        return ResponseEntity.ok().body(perfilService.getCargo(auth.getPrincipal().toString()));
    }

    @PutMapping("/editarcargo")
    public ResponseEntity<String> alterarCargo(Authentication auth, @RequestParam("novoCargo") String novoCargo) {
        return ResponseEntity.ok().body(perfilService.alterarCargo(auth.getPrincipal().toString(), novoCargo));
    }

    @GetMapping("/usernameinstagram")
    public ResponseEntity<String> getUsernameInstagram(Authentication auth) {
        return ResponseEntity.ok().body(perfilService.getUsernameInstagram(auth.getPrincipal().toString()));
    }

    @PutMapping("/editarusernameinstagram")
    public ResponseEntity<String> alterarUsernameInstagram(Authentication auth, @RequestParam("novoUsername") String novoUsername) {
        return ResponseEntity.ok().body(perfilService.alterarUsernameInstagram(auth.getPrincipal().toString(), novoUsername));
    }

    @GetMapping("/usernamefacebook")
    public ResponseEntity<String> getUsernameFacebook(Authentication auth) {
        return ResponseEntity.ok().body(perfilService.getUsernameFacebook(auth.getPrincipal().toString()));
    }

    @PutMapping("/editarusernamefacebook")
    public ResponseEntity<String> alterarUsernameFacebook(Authentication auth, @RequestParam("novoUsername") String novoUsername) {
        return ResponseEntity.ok().body(perfilService.alterarUsernameFacebook(auth.getPrincipal().toString(), novoUsername));
    }

    @GetMapping("/usernametwitter")
    public ResponseEntity<String> getUsernameTwitter(Authentication auth) {
        return ResponseEntity.ok().body(perfilService.getUsernameTwitter(auth.getPrincipal().toString()));
    }

    @PutMapping("/editarusernametwitter")
    public ResponseEntity<String> alterarUsernameTwitter(Authentication auth, @RequestParam("novoUsername") String novoUsername) {
        return ResponseEntity.ok().body(perfilService.alterarUsernameTwitter(auth.getPrincipal().toString(), novoUsername));
    }

    @GetMapping("/listarpgsfavoritos")
    public ResponseEntity<List<String>> getRPGSfavoritos(Authentication auth) {
        return ResponseEntity.ok().body(perfilService.getRPGSfavoritos(auth.getPrincipal().toString()));
    }

    @PostMapping("/adicionar")
    public ResponseEntity<List<String>> adicionarRPGSlistaFavoritos(Authentication auth, @RequestParam("nomeRPG") String nomeRPG) {
        return ResponseEntity.ok().body(perfilService.adicionarRPGSlistaFavoritos(auth.getPrincipal().toString(), nomeRPG));
    }

    @DeleteMapping("/remover")
    public ResponseEntity<List<String>> removerRPGSlistaFavoritos(Authentication auth, @RequestParam("nomeRPG") String nomeRPG) {
        return ResponseEntity.ok().body(perfilService.removerRPGSlistaFavoritos(auth.getPrincipal().toString(), nomeRPG));
    }

}
