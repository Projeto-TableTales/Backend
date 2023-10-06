package com.tabletale.rpgwiki.domain.dto;

import java.util.List;

public record RegisterPersonagemDTO(String nome, int idade, String status, String sistema, String descricao, String personalidade, List<String> tagsPersonagem, String historia){
}
