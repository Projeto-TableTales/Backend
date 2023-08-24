package com.tabletale.rpgwiki.domain.entity;

public enum Genero {

    MASCULINO("M", "MASCULINO"),
    FEMININO("F", "FEMININO"),
    OUTROS("O", "OUTROS");

    private String sigla;
    private String descricao;

    Genero(String sigla, String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public String getDescricao() {
        return descricao;
    }

}