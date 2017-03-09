package fr.marseille.businessmanagement.service;

import java.io.Serializable;
import org.apache.log4j.Logger;
import fr.marseille.businessmanagement.dao.AdresseDAO;
import fr.marseille.businessmanagement.exception.DAOException;
import fr.marseille.businessmanagement.exception.ServiceException;
import fr.marseille.businessmanagement.model.Adresse;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

/**
 * The Class ClientService.
 */
@ManagedBean
public class AdresseService implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * The Constant LOG.
     */
    private static final Logger LOG = Logger.getLogger(AdresseService.class);
    private static final String COMMUNE = "Sénas";
    private static final String CODEPOSTAL = "13560";

    /**
     * DAO
     */
    @ManagedProperty(value = "#{adresseDAO}")
    private AdresseDAO adresseDAO;

    /**
     * Default constructor.
     */
    public AdresseService() {
    }

    public Adresse newAdresse() throws ServiceException {
        return new Adresse(CODEPOSTAL, COMMUNE);
    }

    /**
     * Update.
     *
     * @param adresse the client
     * @return the client
     * @throws ServiceException the service exception
     */
    public Adresse update(Adresse adresse) throws ServiceException {
        try {
            adresseDAO.update(adresse);
            AdresseService.LOG.debug("Log adresse id updated : " + adresse.getId());
        } catch (DAOException e) {
            AdresseService.LOG.error("update : " + e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
        return adresse;
    }

    /**
     * Delete.
     *
     * @param id the id
     * @throws ServiceException the service exception
     */
    public void delete(Integer id) throws ServiceException {
        try {
            adresseDAO.delete(id);
            AdresseService.LOG.debug("Log adresse id deleted : " + id);
        } catch (DAOException e) {
            AdresseService.LOG.error("delete : " + e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * Save.
     *
     * @param adresse the client
     * @return the client
     * @throws ServiceException the service exception
     */
    public Adresse save(Adresse adresse) throws ServiceException {
        try {
            adresseDAO.save(adresse);
            AdresseService.LOG.debug("Log adresse id saved : " + adresse.getId());
        } catch (DAOException e) {
            AdresseService.LOG.error("save : " + e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
        return adresse;
    }

    /**
     * Find.
     *
     * @param id the id
     * @return the client
     * @throws ServiceException the service exception
     */
    public Adresse find(Integer id) throws ServiceException {
        Adresse adresse;
        try {
            adresse = adresseDAO.find(id);
            AdresseService.LOG.debug("Log adresse id found : " + id);
        } catch (DAOException e) {
            AdresseService.LOG.error("find : " + e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
        return adresse;
    }

}
