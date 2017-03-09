package fr.marseille.businessmanagement.view;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import fr.marseille.businessmanagement.enumerated.Civilite;

@ManagedBean
@ApplicationScoped
public class Data {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Civilite[] getCivilites() {
        return Civilite.values();
    }
}
