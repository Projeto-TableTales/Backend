package com.tabletale.rpgwiki.controllers;

import java.io.IOException;
import java.util.List;

import com.tabletale.rpgwiki.domain.dto.RegisterPersonagemDTO;
import com.tabletale.rpgwiki.services.ImagemService;
import com.tabletale.rpgwiki.services.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tabletale.rpgwiki.domain.entity.Personagem;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/personagem")
@CrossOrigin("*")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @Autowired
    private ImagemService imagemService;

    @PostMapping("/adicionarfoto/{id}")
    public void adicionarImagem(@PathVariable("id") String id, @RequestParam("file") MultipartFile file) {
        imagemService.inserirImagemPersonagem(file, id);
    }

    //---------------------------------------------------------------------------------------------------------------------//
    @PostMapping("/criar/{id}")
    public ResponseEntity<?> criarPersonagem(@PathVariable("id") String id, @RequestBody RegisterPersonagemDTO personagemDTO){
        Personagem personagem = new Personagem(personagemDTO.nome(), personagemDTO.idade(), personagemDTO.status(), personagemDTO.sistema(), personagemDTO.descricao(), personagemDTO.personalidade(), personagemDTO.tagsPersonagem(), personagemDTO.historia());
        return ResponseEntity.ok().body(personagemService.criarPersonagem(id, personagem));
    }

    public ResponseEntity<?> excluirPersonagem(@PathVariable("id") String id, @RequestParam("idPersonagem") String idPersonagem) {
        return ResponseEntity.ok().body(personagemService.excluirPersonagem(id, idPersonagem));
    }

    @GetMapping("/buscarTodos/{id}")
    public ResponseEntity<?> buscarTodosPersonagens(@PathVariable("id") String id){
        return ResponseEntity.ok().body(personagemService.buscarTodosPersonagensDoUsuario(id));
    }


    //---------------------- Nome do Personagem ------------------//
    @GetMapping("/nome")
    public ResponseEntity<?> getNomePersonagem(@RequestParam("idPersonagem") String idPersonagem) {
        return ResponseEntity.ok().body(personagemService.getNomePersonagem(idPersonagem));
    }

    @PutMapping("/editarnome")
    public ResponseEntity<?> alterarNomePersonagem(@RequestParam("idPersonagem") String idPersonagem, @RequestParam("novoNome") String novoNome) {
        return ResponseEntity.ok().body(personagemService.alterarNomePersonagem(idPersonagem, novoNome));
    }

    //---------------------- Idade do Personagem ------------------//
    @GetMapping("/idade")
    public ResponseEntity<?> getIdadePersonagem(@RequestParam("idPersonagem") String idPersonagem) {
        return ResponseEntity.ok().body(personagemService.getIdadePersonagem(idPersonagem));
    }

    @PutMapping("/editaridade")
    public ResponseEntity<?> alterarIdadePersonagem(@RequestParam("idPersonagem") String idPersonagem, @RequestParam("novaIdade") int novaIdade) {
        return ResponseEntity.ok().body(personagemService.alterarIdadePersonagem(idPersonagem, novaIdade));
    }

    //---------------------- Status do Personagem ------------------//
    @GetMapping("/status")
    public ResponseEntity<?> getStatusPersonagem(@RequestParam("idPersonagem") String idPersonagem) {
        return ResponseEntity.ok().body(personagemService.getStatusPersonagem(idPersonagem));
    }

    @PutMapping("/editarstatus")
    public ResponseEntity<?> alterarStatusPersonagem(@RequestParam("idPersonagem") String idPersonagem, @RequestParam("novoStatus") String novoStatus) {
        return ResponseEntity.ok().body(personagemService.alterarStatusPersonagem(idPersonagem, novoStatus));
    }

    //---------------------- Sistema RPG do Personagem ------------------//
    @GetMapping("/sistemarpg")
    public ResponseEntity<?> getSistemaRPGPersonagem(@RequestParam("idPersonagem") String idPersonagem) {
        return ResponseEntity.ok().body(personagemService.getSistemaDoRPGPersonagem(idPersonagem));
    }

    @PutMapping("/editarsistemarpg")
    public ResponseEntity<?> alterarSistemaRPGPersonagem(@RequestParam("idPersonagem") String idPersonagem, @RequestParam("novoSistema") String novoSistema) {
        return ResponseEntity.ok().body(personagemService.alterarSistemaDoRPGPersonagem(idPersonagem, novoSistema));
    }

    //---------------------- Descrição do Personagem ------------------//
    @GetMapping("/descricao")
    public ResponseEntity<?> getDescricaoPersonagem(@RequestParam("idPersonagem") String idPersonagem) {
        return ResponseEntity.ok().body(personagemService.getDescricaoPersonagem(idPersonagem));
    }

    @PutMapping("/editardescricao")
    public ResponseEntity<?> alterarDescricaoPersonagem(@RequestParam("idPersonagem") String idPersonagem, @RequestParam("novoDescricao") String novaDescricao) {
        return ResponseEntity.ok().body(personagemService.editarDescricaoPersonagem(idPersonagem, novaDescricao));
    }

    //---------------------- Personalidade do Personagem ------------------//
    @GetMapping("/personalidade")
    public ResponseEntity<?> getPersonalidadePersonagem(@RequestParam("idPersonagem") String idPersonagem) {
        return ResponseEntity.ok().body(personagemService.getPersonalidadePersonagem(idPersonagem));
    }

    @PutMapping("/editarpersonalidade")
    public ResponseEntity<?> alterarPersonalidadePersonagem(@RequestParam("idPersonagem") String idPersonagem, @RequestParam("novaPersonalidade") String novaPersonalidade) {
        return ResponseEntity.ok().body(personagemService.alterarPersonalidadePersonagem(idPersonagem, novaPersonalidade));
    }

    //---------------------- Likes do Personagem ------------------//
    @GetMapping("/likes")
    public ResponseEntity<?> getLikesPersonagem(@RequestParam("idPersonagem") String idPersonagem) {
        return ResponseEntity.ok().body(personagemService.getLikesPersonagem(idPersonagem));
    }

    //---------------------- História dp Personagem ------------------//
    @GetMapping("/historia")
    public ResponseEntity<?> getHistoriaPersonagem(@RequestParam("idPersonagem") String idPersonagem) {
        return ResponseEntity.ok().body(personagemService.getHistoriaPersonagem(idPersonagem));
    }

    @PutMapping("/editarhistoria")
    public ResponseEntity<?> alterarHistoriaPersonagem(@RequestParam("idPersonagem") String idPersonagem, @RequestParam("novaHistoria") String novaHistoria) {
        return ResponseEntity.ok().body(personagemService.editarHistoriaPersonagem(idPersonagem, novaHistoria));
    }

    //---------------------- Tags do Personagem ------------------//
    @GetMapping("/tags")
    public ResponseEntity<?> getTagsPersonagem(@RequestParam("idPersonagem") String idPersonagem) {
        return ResponseEntity.ok().body(personagemService.getTagsPersonagem(idPersonagem));
    }

    @PostMapping("/adiconartag")
    public ResponseEntity<?> adicionarTagPersonagem(@RequestParam("idPersonagem") String idPersonagem, @RequestParam("novaTag") String novaTag) {
        return ResponseEntity.ok().body(personagemService.adicionarTagPersonagem(idPersonagem, novaTag));
    }

    @DeleteMapping("/removertag")
    public ResponseEntity<?> removerTagPersonagem(@RequestParam("idPersonagem") String idPersonagem, @RequestParam("tag") String tag) {
        return ResponseEntity.ok().body(personagemService.removerTagPersonagem(idPersonagem, tag));
    }

}