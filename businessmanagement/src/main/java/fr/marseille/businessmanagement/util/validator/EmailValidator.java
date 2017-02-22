package fr.marseille.businessmanagement.util.validator;

import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

// TODO: Auto-generated Javadoc
/**
 * The Class NoWhiteSpaceValidator.
 */
@FacesValidator("emailValidator")
public class EmailValidator implements Validator {

    private Pattern             pattern;
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public EmailValidator() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    /*
     * (non-Javadoc)
     * @see javax.faces.validator.Validator#validate(javax.faces.context.FacesContext,
     * javax.faces.component.UIComponent, java.lang.Object)
     */
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        
        if (value == null) {
            return;
        }

        if (!pattern.matcher(value.toString()).matches()) {
            FacesMessage msg = new FacesMessage("Incorrect input provided", "Email invalide");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

    }
}
