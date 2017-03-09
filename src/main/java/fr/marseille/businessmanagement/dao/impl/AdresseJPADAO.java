package fr.marseille.businessmanagement.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import org.apache.log4j.Logger;
import fr.marseille.businessmanagement.dao.AdresseDAO;
import fr.marseille.businessmanagement.exception.DAOException;
import fr.marseille.businessmanagement.model.Adresse;
import fr.marseille.businessmanagement.util.JPAUtil;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "adresseDAO")
public class AdresseJPADAO implements AdresseDAO, Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * The Constant LOG.
     */
    private static final Logger LOG = Logger.getLogger(AdresseJPADAO.class);
    protected EntityManager entityManager = JPAUtil.getEntityManager();

    public AdresseJPADAO() {

    }

    @Override
    public boolean save(Adresse adresse) throws DAOException {
        boolean status;

        try {
            JPAUtil.beginTransaction();
            JPAUtil.getEntityManager().persist(adresse);
            //JPAUtil.commitTransaction();
            status = true;
        } catch (RuntimeException e) {
            status = false;
            String msg = "persist : " + e.getMessage();
            LOG.error(msg);
            JPAUtil.rollbackTransaction();
            throw new DAOException(msg, e);
        }

        return status;
    }

    @Override
    public List<Adresse> findAll() throws DAOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Adresse find(Integer id) throws DAOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Adresse update(Adresse adresse) throws DAOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean delete(Integer id) throws DAOException {
        // TODO Auto-generated method stub
        return false;
    }

}
