package com.tabletale.rpgwiki.controller;

import com.tabletale.rpgwiki.domain.Usuario;
import com.tabletale.rpgwiki.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/cadastrar")
    public void adicionarUsuario(@RequestBody Usuario usuario) {
        service.salvar(usuario);
    }

    @GetMapping("/buscarUsuario")
    public Usuario buscarUsuarioPoId(@RequestParam("id") String id) {
        return service.buscarPoId(id);
    }

    @GetMapping("/buscarTodos")
    public List<Usuario> buscarTodosUsuarios() {
        return service.buscarTodos();
    }

}
