package fr.marseille.businessmanagement.service;

import fr.marseille.businessmanagement.dao.ClientDAO;
import fr.marseille.businessmanagement.exception.ServiceException;
import fr.marseille.businessmanagement.model.Client;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class ClientService.
 */
@ManagedBean
public class ClientService implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * The Constant LOG.
     */
    private static final Logger LOG = Logger.getLogger(ClientService.class);

    private static final String FIXE = "0400000000";

    /**
     * The client dao.
     */
    @ManagedProperty(value = "#{clientDAO}")
    private ClientDAO clientDAO;

    /**
     * adresse service
     */
    @ManagedProperty(value = "#{adresseService}")
    private AdresseService adresseService;

    /**
     * Default constructor.
     */
    public ClientService() {
    }

    public Client newClient() throws ServiceException {
        return new Client(clientDAO.assignerCode(), FIXE, adresseService.newAdresse());
    }

    /**
     * Find all.
     *
     * @return the list
     * @throws ServiceException the service exception
     */
    public List<Client> findAll() throws ServiceException {
        return clientDAO.findAll();
    }

    /**
     * Update.
     *
     * @param client the client
     * @return the client
     * @throws ServiceException the service exception
     */
    public Client update(Client client) throws ServiceException {
        return clientDAO.update(client);
    }

    /**
     * Delete.
     *
     * @param id the id
     * @throws ServiceException the service exception
     */
    public void delete(Integer id) throws ServiceException {
        clientDAO.delete(id);
    }

    /**
     * Save.
     *
     * @param client the client
     * @return the client
     * @throws ServiceException the service exception
     */
    public Client save(Client client) throws ServiceException {
        adresseService.save(client.getAdresse());
        return clientDAO.save(client);
    }

    /**
     * Find.
     *
     * @param id the id
     * @return the client
     * @throws ServiceException the service exception
     */
    public Client find(Integer id) throws ServiceException {
        return clientDAO.find(id);
    }

}
