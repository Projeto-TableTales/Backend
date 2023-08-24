package com.tabletale.rpgwiki.controller;

import com.tabletale.rpgwiki.domain.Usuario;
import com.tabletale.rpgwiki.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioConotroller {

    @Autowired
    private UsuarioService service;

}
