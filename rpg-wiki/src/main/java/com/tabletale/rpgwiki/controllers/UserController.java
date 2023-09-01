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

import com.tabletale.rpgwiki.domain.entity.Usuario;
import com.tabletale.rpgwiki.services.UserService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService usuarioService;

    @GetMapping("/buscarTodos")
    public List<Usuario> buscarTodos() {
        return usuarioService.buscarTodos();
    }

    @GetMapping("/buscarPorNome")
    public ResponseEntity<List<Usuario>> buscarUsuario(@RequestParam String nome) {
        List<Usuario> usuario = usuarioService.buscarUsuario(nome);

        if (!usuario.isEmpty()) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/cadastrar")
    public Usuario inserir(@RequestBody Usuario objeto) {
        return usuarioService.criarUsuario(objeto);
    }

    @PutMapping("/editar")
    public Usuario alterar(@RequestBody Usuario objeto) {
        return usuarioService.alterar(objeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") String id) {
        usuarioService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
