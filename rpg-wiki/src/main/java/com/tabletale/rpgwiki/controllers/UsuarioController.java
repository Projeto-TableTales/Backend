package com.tabletale.rpgwiki.controllers;

import java.util.List;

import com.tabletale.rpgwiki.domain.dto.RegisterDTO;
import com.tabletale.rpgwiki.domain.entity.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


    //Deve ter acesso limitado aos Usuários que possuem a Role = "MESTRE"
    @PostMapping("/cadastrar")
    public void inserir(@RequestBody RegisterDTO data) {
        Usuario usuario = new Usuario(data.nome(), data.pais(), data.email(), data.genero(), data.senha(), data.dataNascimento(), UserRole.USER);
        usuarioService.criarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(usuarioService.excluir(id));
    }

}
