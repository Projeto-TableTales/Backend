package com.tabletale.rpgwiki.domain;

public enum Genero {

    MASCULINO("M", "MASCULINO"),
    FEMININO("F", "FEMININO");

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
