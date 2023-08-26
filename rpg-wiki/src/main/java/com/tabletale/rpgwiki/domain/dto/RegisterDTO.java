package com.tabletale.rpgwiki.domain.dto;

import com.tabletale.rpgwiki.domain.entity.UserRole;

public record RegisterDTO(String email, String senha, UserRole role) { }