package com.tabletale.rpgwiki.controller;

import com.tabletale.rpgwiki.service.PersonagemService;
import com.tabletale.rpgwiki.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personagem")
public class PersonagemController {

    @Autowired
    private PersonagemService service;

}
