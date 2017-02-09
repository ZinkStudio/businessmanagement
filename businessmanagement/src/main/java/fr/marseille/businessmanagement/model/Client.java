package fr.marseille.businessmanagement.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import fr.marseille.businessmanagement.enumerated.Civilite;

/**
 * Entity implementation class for Entity: Client
 */
@Entity
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer           id;

    private String            nom;
    private String            prenom;

    @OneToMany(mappedBy = "client", cascade = { CascadeType.ALL })
    private List<Facture>     factures;

    @Enumerated(EnumType.STRING)
    private Civilite          civilite;

    private String            fixe;

    private String            mobile;

    private String            email;

    private String            ville;

    private String            codePostal;

    private String            commentaire;

    public Client() {
    }

    public Client(Integer id, String nom, String prenom) {
        this();
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Client(Integer id, String nom, String prenom, String email) {
        this(id, nom, prenom);
        this.email = email;
    }

    public Client(Integer id, String nom, String prenom, Civilite civilite, String fixe, String mobile, String email,
            String ville, String codePostal, String commentaire) {
        this(id, nom, prenom, email);
        this.civilite = civilite;
        this.fixe = fixe;
        this.mobile = mobile;
        this.ville = ville;
        this.codePostal = codePostal;
        this.commentaire = commentaire;
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
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom
     *            the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom
     *            the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the civilite
     */
    public Civilite getCivilite() {
        return civilite;
    }

    /**
     * @param civilite
     *            the civilite to set
     */
    public void setCivilite(Civilite civilite) {
        this.civilite = civilite;
    }

    /**
     * @return the fixe
     */
    public String getFixe() {
        return fixe;
    }

    /**
     * @param fixe
     *            the fixe to set
     */
    public void setFixe(String fixe) {
        this.fixe = fixe;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile
     *            the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the ville
     */
    public String getVille() {
        return ville;
    }

    /**
     * @param ville
     *            the ville to set
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    /**
     * @return the codePostal
     */
    public String getCodePostal() {
        return codePostal;
    }

    /**
     * @param codePostal
     *            the codePostal to set
     */
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    /**
     * @return the commentaire
     */
    public String getCommentaire() {
        return commentaire;
    }

    /**
     * @param commentaire
     *            the commentaire to set
     */
    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

}
