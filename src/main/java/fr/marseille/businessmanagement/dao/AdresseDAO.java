package fr.marseille.businessmanagement.dao;

import java.util.List;
import fr.marseille.businessmanagement.exception.DAOException;
import fr.marseille.businessmanagement.model.Adresse;

/**
 * The Interface AdresseDAO.
 */
public interface AdresseDAO {

    /**
     * Save.
     *
     * @param adresse the adresse
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    public boolean save(Adresse adresse) throws DAOException;

    /**
     * Find all.
     *
     * @return the list
     * @throws DAOException the DAO exception
     */
    public List<Adresse> findAll() throws DAOException;

    /**
     * Find.
     *
     * @param id the id
     * @return the adresse
     * @throws DAOException the DAO exception
     */
    public Adresse find(Integer id) throws DAOException;

    /**
     * Update.
     *
     * @param adresse the adresse
     * @return the adresse
     * @throws DAOException the DAO exception
     */
    public Adresse update(Adresse adresse) throws DAOException;

    /**
     * Delete.
     *
     * @param id the id
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    public boolean delete(Integer id) throws DAOException;

}
