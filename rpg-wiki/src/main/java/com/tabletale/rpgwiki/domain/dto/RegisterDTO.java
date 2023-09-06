package com.tabletale.rpgwiki.domain.dto;

import com.tabletale.rpgwiki.domain.entity.Pais;
import com.tabletale.rpgwiki.domain.entity.UserRole;

import java.util.Date;

public record RegisterDTO(String nome, Pais pais, String email, String senha, UserRole role, Date dataNascimento) {  }
