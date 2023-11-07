package com.tabletale.rpgwiki.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.tabletale.rpgwiki.domain.entity.Usuario;
import com.tabletale.rpgwiki.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/buscarTodos")
    public List<Usuario> buscarTodos() {
        return usuarioService.buscarTodos();
    }

    @GetMapping("/buscarPorNome")
    public ResponseEntity<List<Usuario>> buscarUsuario(@RequestParam String nome) {
        return ResponseEntity.ok().body(usuarioService.buscarUsuario(nome));
    }

    @DeleteMapping()
    public void excluirUsuario(Authentication auth) {
        usuarioService.exluirUsuario(auth.getPrincipal().toString());
    }

}
