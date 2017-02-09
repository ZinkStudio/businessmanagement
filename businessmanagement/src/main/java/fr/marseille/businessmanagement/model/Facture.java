package fr.marseille.businessmanagement.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import fr.marseille.businessmanagement.enumerated.MoyenPaiement;

/**
 * Entity implementation class for Entity: Facture
 */
@Entity
public class Facture implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer           id;

    private Date              date;

    @ManyToOne
    private Client            client;

    @ManyToMany
    private List<Prestation>  prestations;

    @Enumerated(EnumType.STRING)
    private MoyenPaiement     moyenPaiement;

    private Boolean           estDevis;

    private Boolean           estReglee;

    public Facture() {

    }

    public Facture(Integer id, Client client, Date date, Boolean estDevis, Boolean estReglee) {
        this.id = id;
        this.date = date;
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
     * @param id
     *            the id to set
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
     * @param date
     *            the date to set
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
     * @param estDevis
     *            the estDevis to set
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
     * @param estReglee
     *            the estReglee to set
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
     * @param moyenPaiement
     *            the moyenPaiement to set
     */
    public void setMoyenPaiement(MoyenPaiement moyenPaiement) {
        this.moyenPaiement = moyenPaiement;
    }

}
