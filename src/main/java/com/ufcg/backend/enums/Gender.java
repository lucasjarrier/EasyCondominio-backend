package com.ufcg.backend.enums;

import lombok.Getter;

@Getter
public enum Gender {

    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    NAO_INFORMADO("Não Declarado");

    private String state;

    Gender(String state) {
    this.state = state;
    }
}
