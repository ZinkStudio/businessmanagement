package fr.marseille.businessmanagement.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import fr.marseille.businessmanagement.exception.ServiceException;
import fr.marseille.businessmanagement.model.Client;
import fr.marseille.businessmanagement.service.ClientService;
import fr.marseille.businessmanagement.util.constants.Url;

// TODO: Auto-generated Javadoc
/**
 * The Class ClientView.
 */
@ManagedBean
@SessionScoped
public class ClientView extends BaseView implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The users. */
    private List<Client>      clients;

    /** The user. */
    private Client            client;

    /** The ClientService **/
    private ClientService     clientService    = new ClientService();

    /**
     * Inits the.
     */
    // @PostConstruct
    public void init() {
        clients = new ArrayList<Client>();

        try {
            clients = clientService.findAll();
        } catch (ServiceException e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Client Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    /**
     * Update.
     */
    public void update() {
        try {
            clientService.update(client);
        } catch (ServiceException e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Client Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Updated : " + client.toString()));

        this.redirectWithMessages(Url.CLIENT_INDEX);
    }

    /**
     * Delete.
     */
    public void delete() {
        try {
            clientService.delete(client.getId());
        } catch (ServiceException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error : " + e.getMessage()));
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Client " + client.getId() + " deleted"));

    }

    /**
     * Gets the clients.
     *
     * @return the clients
     */
    public List<Client> getClients() {
        init();
        return clients;
    }

    /**
     * Sets the clients.
     *
     * @param clients
     *            the new clients
     */
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    /**
     * Gets the client.
     *
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * Sets the client.
     *
     * @param client
     *            the new client
     */
    public void setClient(Client client) {
        this.client = client;
    }
}
