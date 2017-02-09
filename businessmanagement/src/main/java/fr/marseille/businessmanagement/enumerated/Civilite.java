package fr.marseille.businessmanagement.enumerated;

public enum Civilite {
    homme, femme;

    public String getStyleClass() {
        return name().toLowerCase();
    }
}
