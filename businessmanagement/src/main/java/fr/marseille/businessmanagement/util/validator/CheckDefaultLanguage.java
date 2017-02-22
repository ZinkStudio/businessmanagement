package fr.marseille.businessmanagement.util.validator;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import fr.marseille.businessmanagement.dao.DAOFactory;
import fr.marseille.businessmanagement.dao.LanguageDAO;
import fr.marseille.businessmanagement.exception.DAOException;
import fr.marseille.businessmanagement.model.Language;

// TODO: Auto-generated Javadoc
/**
 * The Class CheckDefaultLanguage.
 */
@FacesValidator("checkDefaultLanguage")
public class CheckDefaultLanguage implements Validator {

    /** The language dao. */
    private LanguageDAO languageDAO  = DAOFactory.getLanguageDAO();
    
    /** The error message. */
    private String      errorMessage = "there is no default language yet ! this one has to be a default one";

    /* (non-Javadoc)
     * @see javax.faces.validator.Validator#validate(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
     */
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        List<Language> languages = new ArrayList<Language>();

        try {
            languages = languageDAO.findDefaultLanguages();
        } catch (DAOException e) {
            errorMessage = e.getMessage();
        }

        if (languages.isEmpty() && false == Boolean.parseBoolean(value.toString())) {
            FacesMessage msg = new FacesMessage("Incorrect input provided", errorMessage);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);

        }

    }
}
