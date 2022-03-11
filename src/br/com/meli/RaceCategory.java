package br.com.meli;

public enum RaceCategory {
    SHORT("Curto"),
    MEDIUM("Médio"),
    ADVANCED("Avançado");

    public final String label;

    RaceCategory(String label) {
        this.label = label;
    }
}