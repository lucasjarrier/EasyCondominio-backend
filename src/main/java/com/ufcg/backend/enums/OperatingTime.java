package com.ufcg.backend.enums;

import lombok.Getter;

@Getter
public enum OperatingTime {

    MATUTINO("Manhã"),
    VESPERTINO("Tarde"),
    DIURNO("Manhã, Tarde e Noite");

    private final String state;

    /**
     * Horarios de funcionamento
     */
    private final String[] manha = {"08", "09", "10", "11"};
    private final String[] tarde = {"14", "15", "16", "17"};
    private final String[] total = {"08", "09", "10", "11", "12", "14", "15", "16", "17", "18", "19", "20", "21"};

    OperatingTime(String state) {
    this.state = state;
    }


    /**
     * O default vai ser o horário completo.
     */
    public String[] getReservas(OperatingTime tipo) {
        if (tipo.equals(MATUTINO)) {
           return this.manha;
        } else if (tipo.equals(VESPERTINO)) {
            return this.tarde;
        } else  {
            return this.total;
        }
    }
}
