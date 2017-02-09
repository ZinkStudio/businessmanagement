package fr.marseille.businessmanagement.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: Prestation
 */
@Entity
public class Prestation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer           id;

    private String            libelle;

    private String            description;

    private Double            prixUnitaire;

    @ManyToMany(mappedBy = "prestations")
    private List<Facture>     factures;

    public Prestation() {

    }

}
