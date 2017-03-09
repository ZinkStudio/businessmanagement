package fr.marseille.businessmanagement.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import fr.marseille.businessmanagement.enumerated.Civilite;
import fr.marseille.businessmanagement.view.Data;

/**
 * Entity implementation class for Entity: Client
 */
@Entity
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Boolean estMasque;
    private Boolean autoriseNewsletter;

    private String code;
    private String nom;
    private String prenom;

    @OneToMany(mappedBy = "client")
    private List<Facture> factures;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    private Adresse adresse;

    @Enumerated(EnumType.STRING)
    private Civilite civilite;

    private Date naissance;

    private String fixe;

    private String mobile;

    private String email;

    private String commentaire;

    public Client() {
    }

    public Client(String code, String fixe, Adresse adresse) {
        this();
        this.code = code;
        this.fixe = fixe;
        this.adresse = adresse;
        this.estMasque = false;
        this.autoriseNewsletter = true;
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
            String commentaire) {
        this(id, nom, prenom, email);
        this.civilite = civilite;
        this.fixe = fixe;
        this.mobile = mobile;
        this.commentaire = commentaire;
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
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
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
     * @param prenom the prenom to set
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
     * @param civilite the civilite to set
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
     * @param fixe the fixe to set
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
     * @param mobile the mobile to set
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
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the commentaire
     */
    public String getCommentaire() {
        return commentaire;
    }

    /**
     * @param commentaire the commentaire to set
     */
    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Date getNaissance() {
        return naissance;
    }

    public void setNaissance(Date naissance) {
        this.naissance = naissance;
    }

    public Boolean getEstMasque() {
        return estMasque;
    }

    public void setEstMasque(Boolean estMasque) {
        this.estMasque = estMasque;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Boolean getAutoriseNewsletter() {
        return autoriseNewsletter;
    }

    public void setAutoriseNewsletter(Boolean autoriseNewsletter) {
        this.autoriseNewsletter = autoriseNewsletter;
    }

    public List<Facture> getFactures() {
        return factures;
    }

    public void setFactures(List<Facture> factures) {
        this.factures = factures;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
