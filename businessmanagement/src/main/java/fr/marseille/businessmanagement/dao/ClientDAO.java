package fr.marseille.businessmanagement.dao;

import java.util.List;
import fr.marseille.businessmanagement.exception.DAOException;
import fr.marseille.businessmanagement.model.Client;

// TODO: Auto-generated Javadoc
/**
 * The Interface ClientDAO.
 */
public interface ClientDAO {

    /**
     * Save.
     *
     * @param client
     *            the client
     * @return true, if successful
     * @throws DAOException
     *             the DAO exception
     */
    public boolean save(Client client) throws DAOException;

    /**
     * Find all.
     *
     * @return the list
     * @throws DAOException
     *             the DAO exception
     */
    public List<Client> findAll() throws DAOException;

    /**
     * Find.
     *
     * @param id
     *            the id
     * @return the client
     * @throws DAOException
     *             the DAO exception
     */
    public Client find(Integer id) throws DAOException;

    /**
     * Update.
     *
     * @param client
     *            the client
     * @return the client
     * @throws DAOException
     *             the DAO exception
     */
    public Client update(Client client) throws DAOException;

    /**
     * Delete.
     *
     * @param id
     *            the id
     * @return true, if successful
     * @throws DAOException
     *             the DAO exception
     */
    public boolean delete(Integer id) throws DAOException;

}