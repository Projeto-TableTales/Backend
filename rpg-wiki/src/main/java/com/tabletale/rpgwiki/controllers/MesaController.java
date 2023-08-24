package com.tabletale.rpgwiki.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tabletale.rpgwiki.domain.entity.Mesa;
import com.tabletale.rpgwiki.services.MesaService;



@RestController
@RequestMapping("/api/Mesa")
@CrossOrigin
public class MesaController {
    
    @Autowired
    private MesaService mesaService;

    @GetMapping("/")
    public List<Mesa> buscarTodos(){
       return mesaService.buscarTodos();
    }

    @GetMapping("/buscarMesa")
    public ResponseEntity<List<Mesa>> buscarMesa(@RequestParam String nome) {
        List<Mesa> produtos = mesaService.buscarMesa(nome);

        if (!produtos.isEmpty()) {
            return ResponseEntity.ok(produtos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/")
    public Mesa inserir(@RequestBody Mesa objeto){
        return mesaService.criarMesa(objeto);
    }

    @PutMapping("/")
    public Mesa alterar(@RequestBody Mesa objeto){
        return mesaService.alterar(objeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") String id){
        mesaService.excluir(id);
        return ResponseEntity.ok().build();
    }

}