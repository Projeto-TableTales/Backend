package com.tabletale.rpgwiki.domain.dto;

import java.time.LocalDate;
import java.util.Date;

import com.tabletale.rpgwiki.domain.entity.Genero;
import com.tabletale.rpgwiki.domain.entity.Pais;
import com.tabletale.rpgwiki.domain.entity.UserRole;

public record RegisterDTO(String nome, Pais pais, String email, String senha, Genero genero, UserRole role,
                          String biografia, LocalDate dataNascimento ) {
}
