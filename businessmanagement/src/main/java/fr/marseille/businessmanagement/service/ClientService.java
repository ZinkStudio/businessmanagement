package fr.marseille.businessmanagement.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import fr.marseille.businessmanagement.dao.ClientDAO;
import fr.marseille.businessmanagement.dao.DAOFactory;
import fr.marseille.businessmanagement.enumerated.Civilite;
import fr.marseille.businessmanagement.exception.DAOException;
import fr.marseille.businessmanagement.exception.ServiceException;
import fr.marseille.businessmanagement.model.Client;

// TODO: Auto-generated Javadoc
/**
 * The Class ClientService.
 */
public class ClientService {

    /** The Constant LOG. */
    private static final Logger LOG       = Logger.getLogger(ClientService.class);

    /** The client dao. */
    private ClientDAO           clientDAO = DAOFactory.getClientDAO();

    /**
     * Default constructor.
     */
    public ClientService() {
    }

    /**
     * Creates the clients.
     *
     * @return the list
     */
    public List<Client> createClients() {
        List<Client> clients = new ArrayList<Client>();

        for (int i = 0; i < 10; i++) {
            clients.add(new Client(i, "nom" + i, "prenom" + i, Civilite.homme, "0411223344", "0644556677",
                    "email@aze.fr", "marseille", "13013", "commentaire"));
        }
        return clients;
    }

    /**
     * Find all.
     *
     * @return the list
     * @throws ServiceException
     *             the service exception
     */
    public List<Client> findAll() throws ServiceException {
        List<Client> clients = new ArrayList<>();
        try {
            clients = clientDAO.findAll();
            ClientService.LOG.debug("clients found : " + clients.size());
        } catch (DAOException e) {
            ClientService.LOG.error("findAll : " + e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
        return clients;
    }

    /**
     * Update.
     *
     * @param client
     *            the client
     * @return the client
     * @throws ServiceException
     *             the service exception
     */
    public Client update(Client client) throws ServiceException {
        try {
            clientDAO.update(client);
            ClientService.LOG.debug("Log client id updated : " + client.getId());
        } catch (DAOException e) {
            ClientService.LOG.error("update : " + e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
        return client;
    }

    /**
     * Delete.
     *
     * @param id
     *            the id
     * @throws ServiceException
     *             the service exception
     */
    public void delete(Integer id) throws ServiceException {
        try {
            clientDAO.delete(id);
            ClientService.LOG.debug("Log client id deleted : " + id);
        } catch (DAOException e) {
            ClientService.LOG.error("delete : " + e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * Save.
     *
     * @param client
     *            the client
     * @return the client
     * @throws ServiceException
     *             the service exception
     */
    public Client save(Client client) throws ServiceException {
        try {
            clientDAO.save(client);
            ClientService.LOG.debug("Log client id saved : " + client.getId());
        } catch (DAOException e) {
            ClientService.LOG.error("save : " + e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
        return client;
    }

    /**
     * Find.
     *
     * @param id
     *            the id
     * @return the client
     * @throws ServiceException
     *             the service exception
     */

    public Client find(Integer id) throws ServiceException {
        Client client;
        try {
            client = clientDAO.find(id);
            ClientService.LOG.debug("Log client id found : " + id);
        } catch (DAOException e) {
            ClientService.LOG.error("find : " + e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
        return client;
    }

}