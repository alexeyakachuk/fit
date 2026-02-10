package com.fit.fit.enums;

public enum Activity {
    SEDENTARY("Сидячая"),
    MODERATE("Умеренная"),
    ACTIVE("Активная");

    private final String label;

    Activity(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
