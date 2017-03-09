package fr.marseille.businessmanagement.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToOne;
import fr.marseille.businessmanagement.enumerated.MoyenPaiement;

/**
 * Entity implementation class for Entity: Facture
 */
@Entity
public class Facture implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Date date;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Adresse adresse;

    @ElementCollection
    @CollectionTable(name = "facture_prestation")
    @MapKeyJoinColumn(name = "prestations_id")
    @Column(name = "quantite")
    private Map<Prestation, Double> prestations;

    @Enumerated(EnumType.STRING)
    private MoyenPaiement moyenPaiement;

    private Boolean estDevis;

    private Boolean estReglee;

    public Facture() {
        prestations = new HashMap<Prestation, Double>();
    }

    public Facture(Integer id, Client client, Date date, Boolean estDevis, Boolean estReglee) {
        this();
        this.id = id;
        this.date = date;
        //this.adresse = client.get
        this.client = client;
        this.estDevis = estDevis;
        this.estReglee = estReglee;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the estDevis
     */
    public Boolean getEstDevis() {
        return estDevis;
    }

    /**
     * @param estDevis the estDevis to set
     */
    public void setEstDevis(Boolean estDevis) {
        this.estDevis = estDevis;
    }

    /**
     * @return the estReglee
     */
    public Boolean getEstReglee() {
        return estReglee;
    }

    /**
     * @param estReglee the estReglee to set
     */
    public void setEstReglee(Boolean estReglee) {
        this.estReglee = estReglee;
    }

    /**
     * @return the moyenPaiement
     */
    public MoyenPaiement getMoyenPaiement() {
        return moyenPaiement;
    }

    /**
     * @param moyenPaiement the moyenPaiement to set
     */
    public void setMoyenPaiement(MoyenPaiement moyenPaiement) {
        this.moyenPaiement = moyenPaiement;
    }

    public Map<Prestation, Double> getPrestations() {
        return prestations;
    }

    public void setPrestations(Map<Prestation, Double> prestations) {
        this.prestations = prestations;
    }

    public void addPrestation(Prestation prestation, Double quantite) {
        this.prestations.put(prestation, quantite);
    }

    public void removePrestation(Prestation prestation) {
        this.prestations.remove(prestation);
    }

}
