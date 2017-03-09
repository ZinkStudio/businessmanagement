package fr.marseille.businessmanagement.enumerated;

public enum Civilite {
    monsieur, madame;

    public String getStyleClass() {
        return name().toLowerCase();
    }
}
