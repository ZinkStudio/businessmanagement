package fr.marseille.businessmanagement.view;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import fr.marseille.businessmanagement.exception.ServiceException;
import fr.marseille.businessmanagement.model.Client;
import fr.marseille.businessmanagement.service.ClientService;

// TODO: Auto-generated Javadoc
/**
 * The Class ClientSaveView.
 */
@ManagedBean
@RequestScoped
public class ClientSaveView extends BaseView {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The client service.
     */
    private ClientService clientService = new ClientService();

    /**
     * The client.
     */
    private Client client;

    /**
     * Inits the.
     */
    @PostConstruct
    public void init() {
        try {
            client = clientService.newClient();
        } catch (ServiceException e) {
            client = new Client();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Error while Generating Client Code : " + e.getMessage()));
        }
    }

    /**
     * Save.
     */
    public void save() {
        try {
            clientService.save(client);
        } catch (ServiceException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Error while Saving Client : " + e.getMessage()));
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Saved"));

        this.redirectWithMessages("clientIndex.jsf");
    }

    /**
     * Gets the client.
     *
     * @return the client
     */
    public Client getClient() {
        return this.client;
    }

    /**
     * Sets the client
     *
     * @param client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Instantiates a new client save view.
     */
    public ClientSaveView() {
        super();
    }

}
