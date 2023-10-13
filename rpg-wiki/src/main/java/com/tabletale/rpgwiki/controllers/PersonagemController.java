package com.tabletale.rpgwiki.controllers;

import java.util.List;

import com.tabletale.rpgwiki.domain.dto.RegisterPersonagemDTO;
import com.tabletale.rpgwiki.services.ImagensService;
import com.tabletale.rpgwiki.services.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tabletale.rpgwiki.domain.entity.Personagem;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/personagem")
@CrossOrigin("*")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @Autowired
    private ImagensService imagensService;

    @PostMapping("/adicionarImagempersonagem/{id}")
    public void adicionarImagemPerfil(@PathVariable("id") String id, @RequestParam("idPersonagem") String idPersonagem, @RequestParam("file") MultipartFile file){
        imagensService.inserirImagemPersonagem(file, id, idPersonagem);
    }

    @PostMapping("/criar/{id}")
    public void criarPersonagem(@PathVariable("id") String id, @RequestBody RegisterPersonagemDTO personagemDTO){
        Personagem personagem = new Personagem(personagemDTO.nome(), personagemDTO.idade(), personagemDTO.status(), personagemDTO.sistema(), personagemDTO.descricao(), personagemDTO.personalidade(), personagemDTO.tagsPersonagem(), personagemDTO.historia());
        personagemService.criarPersonagem(id, personagem);
    }

    @GetMapping("/buscarTodos/{id}")
    public List<Personagem> buscarTodosPersonagens(@PathVariable("id") String id){
        return personagemService.buscarTodosPersonagensDoUsuario(id);
    }

    //-------------------------Funções Auxiliares-------------------//
    @GetMapping("/nomepersonagem/{id}")
    public String getNomePersonagem(@PathVariable("id") String id, @RequestParam("idPersonagem") String idPersonagem) {
        return personagemService.getNomePersonagem(id, idPersonagem);
    }

    @GetMapping("/idadepersonagem/{id}")
    public int getIdadePersonagem(@PathVariable("id") String id, @RequestParam("idPersonagem") String idPersonagem) {
        return personagemService.getIdadePersonagem(id, idPersonagem);
    }

    @GetMapping("/statuspersonagem/{id}")
    public String getStatusPersonagem(@PathVariable("id") String id, @RequestParam("idPersonagem") String idPersonagem) {
        return personagemService.getStatusPersonagem(id, idPersonagem);
    }

    @GetMapping("/sistemarpgpersonagem/{id}")
    public String getSistemaRPGPersonagem(@PathVariable("id") String id, @RequestParam("idPersonagem") String idPersonagem) {
        return personagemService.getSistemaDoRPGPersonagem(id, idPersonagem);
    }

    @GetMapping("/descricaopersonagem/{id}")
    public String getDescricaoPersonagem(@PathVariable("id") String id, @RequestParam("idPersonagem") String idPersonagem) {
        return personagemService.getDescricaoPersonagem(id, idPersonagem);
    }

    @GetMapping("/personalidadepersonagem/{id}")
    public String getPersonalidadePersonagem(@PathVariable("id") String id, @RequestParam("idPersonagem") String idPersonagem) {
        return personagemService.getPersonalidadePersonagem(id, idPersonagem);
    }

    @GetMapping("/likespersonagem/{id}")
    public int getLikesPersonagem(@PathVariable("id") String id, @RequestParam("idPersonagem") String idPersonagem) {
        return personagemService.getLikesPersonagem(id, idPersonagem);
    }

    @GetMapping("/historiapersonagem/{id}")
    public String getHistoriaPersonagem(@PathVariable("id") String id, @RequestParam("idPersonagem") String idPersonagem) {
        return personagemService.getHistoriaPersonagem(id, idPersonagem);
    }

    @GetMapping("/tagspersonagem/{id}")
    public List<String> getTagsPersonagem(@PathVariable("id") String id, @RequestParam("idPersonagem") String idPersonagem) {
        return personagemService.getTagsPersonagem(id, idPersonagem);
    }

    @PostMapping("/adiconartagpersonagem/{id}")
    public List<String> adicionarTagPersonagem(@PathVariable("id") String id, @RequestParam("idPersonagem") String idPersonagem, @RequestParam("novaTag") String novaTag) {
        return personagemService.adicionarTagPersonagem(id, idPersonagem, novaTag);
    }

    @DeleteMapping("/removertagpersonagem/{id}")
    public List<String> removerTagPersonagem(@PathVariable("id") String id, @RequestParam("idPersonagem") String idPersonagem, @RequestParam("tag") String tag) {
        return personagemService.removerTagPersonagem(id, idPersonagem, tag);
    }

}