package com.desafios.exercicios_spring_data_jpa.aula1.enums;

public enum Mes {
    //ex6
    JANEIRO(31),
    FEVEREIRO(28),
    MARCO(31),
    ABRIL(30),
    MAIO(31),
    JUNHO(30),
    JULHO(31),
    AGOSTO(31),
    SETEMBRO(30),
    OUTUBRO(31),
    NOVEMBRO(30),
    DEZEMBRO(31);

    private final int dias;
    Mes(int dias) {
        this.dias = dias;
    }

    public int getNumeroDeDias() {
        return dias;
    }
}
