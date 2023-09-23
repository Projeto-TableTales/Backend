package com.tabletale.rpgwiki.controllers;

import com.tabletale.rpgwiki.services.dao.PerfilServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String getName(@PathVariable("id") String id) {
        return perfilService.getName(id);
    }

    @GetMapping("/biografia/{id}")
    public String getBiografia(@PathVariable("id") String id) {
        return perfilService.getBiografia(id);
    }

    @PutMapping("/editarbiografia/{id}")
    public String alterarBiografia(@PathVariable("id") String id, @RequestParam("novaBiografia") String novaBiografia) {
        return perfilService.alterarBiografia(id, novaBiografia);
    }

    @GetMapping("/pais/{id}")
    public String getPais(@PathVariable("id") String id) {
        return perfilService.getPais(id);
    }

    //----------------- Funções relacionadas aos Links de Redes Sociais do Usuario ----------------//
    @GetMapping("/usernameinstagram/{id}")
    public String getUsernameInstagram(@PathVariable("id") String id) {
        return perfilService.getUsernameInstagram(id);
    }

    @PutMapping("/editarusernameinstagram/{id}")
    public String alterarUsernameInstagram(@PathVariable("id") String id, @RequestParam("novoUsername") String novoUsername) {
        return perfilService.alterarUsernameInstagram(id, novoUsername);
    }

    @GetMapping("/usernamefacebook/{id}")
    public String getUsernameFacebook(@PathVariable("id") String id) {
        return perfilService.getUsernameFacebook(id);
    }

    @PutMapping("/editarusernamefacebook/{id}")
    public String alterarUsernameFacebook(@PathVariable("id") String id, @RequestParam("novoUsername") String novoUsername) {
        return perfilService.alterarUsernameFacebook(id, novoUsername);
    }

    @GetMapping("/usernametwitter/{id}")
    public String getUsernameTwitter(@PathVariable("id") String id) {
        return perfilService.getUsernameTwitter(id);
    }

    @PutMapping("/editarusernametwitter/{id}")
    public String alterarUsernameTwitter(@PathVariable("id") String id, @RequestParam("novoUsername") String novoUsername) {
        return perfilService.alterarUsernameTwitter(id, novoUsername);
    }

    //------------------- Funções relacionadas a lista de RPGs Favoritos do Usuario -----------------------//
    @GetMapping("/listarpgsfavoritos/{id}")
    public List<String> getRPGSfavoritos(@PathVariable("id") String id) {
        return perfilService.getRPGSfavoritos(id);
    }

    //Necessário ainda trabalhar com exeções para caso o nome do RPG passado para ser adicionado já esteja na lista de RPGs do Usuário.
    @PostMapping("/adicionar/{id}")
    public List<String> adicionarRPGSlistaFavoritos(@PathVariable("id") String id, @RequestParam("nomeRPG") String nomeRPG) {
        perfilService.adicionarRPGSlistaFavoritos(id, nomeRPG);
        return perfilService.getRPGSfavoritos(id);
    }

    //Necessário ainda trabalhar com exeções para caso o nome do RPG passado para ser removido não esteja na lista de RPGs do Usuário.
    @DeleteMapping("/remover/{id}")
    public List<String> removerRPGSlistaFavoritos(@PathVariable("id") String id, @RequestParam("nomeRPG") String nomeRPG) {
        perfilService.removerRPGSlistaFavoritos(id, nomeRPG);
        return perfilService.getRPGSfavoritos(id);
    }

}
