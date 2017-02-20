package fr.marseille.businessmanagement.dao;

import java.util.List;
import fr.marseille.businessmanagement.exception.DAOException;
import fr.marseille.businessmanagement.model.Facture;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProfileDAO.
 */
public interface FactureDAO {

    /**
     * Save.
     */
    public boolean save(Facture facture) throws DAOException;

    /**
     * Find all.
     *
     * @return the list
     * @throws DAOException the DAO exception
     */
    public List<Facture> findAll() throws DAOException;

    /**
     * Find.
     */
    public Facture find(Integer id) throws DAOException;

    /**
     * Update.
     */
    public Facture update(Facture facture) throws DAOException;

    /**
     * Delete.
     *
     * @param id the id
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    public boolean delete(Integer id) throws DAOException;

}