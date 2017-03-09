package fr.marseille.businessmanagement.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Adresse
 */
@Entity
public class Adresse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String libelle;
    private String complement;
    private String codePostal;
    private String commune;

    @OneToOne(mappedBy = "adresse")
    private Client client;

    @OneToOne(mappedBy = "adresse")
    private Societe societe;

    public Adresse() {
        super();
    }

    public Adresse(String codePostal, String commune) {
        this();
        this.commune = commune;
        this.codePostal = codePostal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Societe getSociete() {
        return societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }

}
