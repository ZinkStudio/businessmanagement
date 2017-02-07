package fr.marseille.businessmanagement.view;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import fr.marseille.businessmanagement.exception.ServiceException;
import fr.marseille.businessmanagement.model.Language;
import fr.marseille.businessmanagement.service.LanguageService;

// TODO: Auto-generated Javadoc
/**
 * The Class LanguageSaveView.
 */
@ManagedBean
@RequestScoped
public class LanguageSaveView extends BaseView implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The service. */
    private LanguageService   service          = new LanguageService();

    /** The language. */
    private Language          language;

    /**
     * Inits the.
     */
    @PostConstruct
    public void init() {
        language = new Language();
    }

    /**
     * Save.
     */
    public void save() {
        try {
            service.save(language);
        } catch (ServiceException e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Language Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Saved : " + language.toString()));

        this.redirectWithMessages("languageIndex.jsf");
    }

    /**
     * @return the service
     */
    public LanguageService getService() {
        return service;
    }

    /**
     * @param service
     *            the service to set
     */
    public void setService(LanguageService service) {
        this.service = service;
    }

    /**
     * Gets the language.
     *
     * @return the language
     */
    public Language getLanguage() {
        return language;
    }

    /**
     * Sets the language.
     *
     * @param language
     *            the new language
     */
    public void setLanguage(Language language) {
        this.language = language;
    }

}
