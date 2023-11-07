package com.tabletale.rpgwiki.domain.dto;

import java.time.LocalDate;

import com.tabletale.rpgwiki.domain.entity.enums.Genero;
import com.tabletale.rpgwiki.domain.entity.enums.Pais;


public record RegisterDTO(String nome, Pais pais, String email, String senha, Genero genero,
                         LocalDate dataNascimento ) {}
