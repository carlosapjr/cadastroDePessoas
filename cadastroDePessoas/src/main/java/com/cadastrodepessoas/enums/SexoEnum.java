package com.cadastrodepessoas.enums;

public enum SexoEnum {

    FEMININO("Feminino","F"),
    MASCULINO("Masculino","M");
    
    private final String label;
    private final String value;

    private SexoEnum(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }
}
