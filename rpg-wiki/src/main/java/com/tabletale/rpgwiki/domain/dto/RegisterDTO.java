package com.tabletale.rpgwiki.domain.dto;

import java.time.LocalDate;

import com.tabletale.rpgwiki.domain.entity.enums.Genero;
import com.tabletale.rpgwiki.domain.entity.enums.Pais;
import com.tabletale.rpgwiki.domain.entity.enums.UserRole;

public record RegisterDTO(String nome, Pais pais, String email, String senha, Genero genero,
                         LocalDate dataNascimento ) {}
