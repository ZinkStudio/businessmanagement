package fr.marseille.businessmanagement.view;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

// TODO: Auto-generated Javadoc
/**
 * The Class TabMenuView.
 */
@ManagedBean

public class TabMenuView {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The index.
     */
    private int index = 0;

    /**
     * Gets the index.
     *
     * @return the index
     */
    private int getIndex() {
        return index;
    }

    /**
     * Sets the index.
     *
     * @param index the new index
     */
    private void setIndex(int index) {
        this.index = index;
    }

    /**
     * Inits the.
     */
    @PostConstruct
    public void init() {

    }
}
