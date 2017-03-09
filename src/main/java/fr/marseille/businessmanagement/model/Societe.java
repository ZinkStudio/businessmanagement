package fr.marseille.businessmanagement.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Societe
 *
 */
@Entity
public class Societe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nom;
    private String siren;

    @OneToOne(fetch = FetchType.LAZY)
    private Adresse adresse;

    public Societe() {
        super();
    }

}
