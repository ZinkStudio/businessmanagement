package fr.marseille.businessmanagement.view;

import fr.marseille.businessmanagement.exception.ServiceException;
import fr.marseille.businessmanagement.model.Client;
import fr.marseille.businessmanagement.service.ClientService;
import fr.marseille.businessmanagement.util.JSFUtil;
import fr.marseille.businessmanagement.util.constants.Url;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

/**
 * The Class ClientView.
 */
@ManagedBean
public class ClientView extends BaseView {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The ClientService
     */
    @ManagedProperty(value = "#{clientService}")
    private ClientService clientService;

    /**
     * The clients.
     */
    private final List<Client> clients = new ArrayList<>();

    /**
     * The filtre clients.
     */
    private final List<Client> filtreClients = new ArrayList<>();

    /**
     * The Client.
     */
    private Client client;

    /**
     * Inits the.
     */
    // @PostConstruct
    public void init() {

        try {
            clients.addAll(clientService.findAll());

        } catch (ServiceException e) {
            JSFUtil.addErrorMessage("Client Error", e.getMessage());
        }
    }

    /**
     * Update.
     */
    public void update() {
        try {
            clientService.update(client);
        } catch (ServiceException e) {
            JSFUtil.addErrorMessage("Client error", e.getMessage());
        }

        JSFUtil.addInfoMessage("Data updated", client.toString());

        this.redirectWithMessages(Url.CLIENT_INDEX);
    }

    /**
     * Delete.
     */
    public void delete() {
        try {
            clientService.delete(client.getId());

        } catch (ServiceException e) {
            JSFUtil.addErrorMessage("Client Error", e.getMessage());
        }

        JSFUtil.addInfoMessage("Success", "Client " + client.getId() + " deleted");

        this.redirectWithMessages(Url.CLIENT_INDEX);
    }

    public boolean filtreNom(Object value, Object filter, Locale locale) {
        return this.filterByValue(value, filter, locale);
    }

    public boolean filtrePrenom(Object value, Object filter, Locale locale) {
        return this.filterByValue(value, filter, locale);
    }

    public boolean filtreVille(Object value, Object filter, Locale locale) {
        return this.filterByValue(value, filter, locale);
    }

    public boolean filtreCodePostal(Object value, Object filter, Locale locale) {
        return this.filterByValue(value, filter, locale);
    }

    public boolean filtreCommentaire(Object value, Object filter, Locale locale) {
        return this.filterByValue(value, filter, locale);
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

    public List<Client> getFiltreClients() {
        return filtreClients;
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
     * @param client the new client
     */
    public void setClient(Client client) {
        this.client = client;
    }

}
