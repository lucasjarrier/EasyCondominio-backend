package com.ufcg.backend.enums;

public enum Gender {

    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    NAO_INFORMADO("Não Declarado");

    private final String state;

    Gender(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}