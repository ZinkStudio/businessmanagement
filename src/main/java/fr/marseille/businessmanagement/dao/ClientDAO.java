package fr.marseille.businessmanagement.dao;

import java.util.List;
import fr.marseille.businessmanagement.exception.DAOException;
import fr.marseille.businessmanagement.model.Client;

/**
 * The Interface ClientDAO.
 */
public interface ClientDAO {

    public void refuseNewsletter(Client client) throws DAOException;

    public void autoriseNewsletter(Client client) throws DAOException;

    public void mask(Client client) throws DAOException;

    public void mask(List<Client> clients) throws DAOException;

    public String assignerCode() throws DAOException;

    public Boolean verifierCode(String code) throws DAOException;

    public String genererCode() throws DAOException;

    /**
     * Save.
     *
     * @param client the client
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    public Client save(Client client) throws DAOException;

    /**
     * Find all.
     *
     * @return the list
     * @throws DAOException the DAO exception
     */
    public List<Client> findAll() throws DAOException;

    /**
     * Find.
     *
     * @param id the id
     * @return the client
     * @throws DAOException the DAO exception
     */
    public Client find(Integer id) throws DAOException;

    /**
     * Update.
     *
     * @param client the client
     * @return the client
     * @throws DAOException the DAO exception
     */
    public Client update(Client client) throws DAOException;

    /**
     * Delete.
     *
     * @param id the id
     * @return true, if successful
     * @throws DAOException the DAO exception
     */
    public boolean delete(Integer id) throws DAOException;

}
