package com.fit.fit.enums;

public enum Gender {
    MAN("Мужчина"),
    WOMAN("Женщина");

    private final String label;

    Gender(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
