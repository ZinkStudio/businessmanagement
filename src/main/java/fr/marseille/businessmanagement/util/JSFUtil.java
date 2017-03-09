package fr.marseille.businessmanagement.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * The Class JSFtil.
 */
public class JSFUtil {

    public static FacesContext facesContext() {

        return FacesContext.getCurrentInstance();
    }

    public static ExternalContext externalContext() {

        return facesContext().getExternalContext();
    }

    public static void addInfoMessage(final String title, final String message) {

        facesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, title, message));
    }

    public static void addWarningMessage(final String title, final String message) {

        facesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, title, message));
    }

    public static void addErrorMessage(final String title, final String message) {

        facesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, title, message));
    }

    public static void addFatalMessage(final String title, final String message) {

        facesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, title, message));
    }

}
