package fr.marseille.businessmanagement.view;

import java.io.Serializable;
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
public class ClientSaveView extends BaseView implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The client service. */
    private ClientService     clientService    = new ClientService();

    /** The client. */
    private Client            client;

    /**
     * Inits the.
     */
    @PostConstruct
    public void init() {
        client = new Client();
    }

    /**
     * Save.
     */
    public void save() {
        try {
            clientService.save(client);
        } catch (ServiceException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Error while Saving Client: " + e.getMessage()));
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
     * Instantiates a new client save view.
     */
    public ClientSaveView() {
        super();
    }

}
