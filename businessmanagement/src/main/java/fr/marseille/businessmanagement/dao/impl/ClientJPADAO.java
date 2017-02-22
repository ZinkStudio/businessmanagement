package fr.marseille.businessmanagement.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import org.apache.log4j.Logger;
import fr.marseille.businessmanagement.dao.ClientDAO;
import fr.marseille.businessmanagement.exception.DAOException;
import fr.marseille.businessmanagement.model.Client;
import fr.marseille.businessmanagement.util.JPAUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class ClientJPADAO.
 */
public class ClientJPADAO implements ClientDAO {

    /** The Constant LOG. */
    private static final Logger LOG           = Logger.getLogger(ClientJPADAO.class);
    protected EntityManager     entityManager = JPAUtil.getEntityManager();

    /**
     * Default constructor.
     */
    public ClientJPADAO() {
    }

    /*
     * (non-Javadoc)
     * @see fr.marseille.permissionmanagement.dao.ClientDAO#save(fr.marseille.permissionmanagement.model.Client)
     */
    @Override
    public boolean save(Client client) throws DAOException {
        try {
            JPAUtil.beginTransaction();
            entityManager.persist(client);
            JPAUtil.commitTransaction();
        } catch (RuntimeException e) {
            String msg = "save : " + e.getMessage();
            LOG.warn(msg);
            JPAUtil.rollbackTransaction();
            throw new DAOException(msg, e);
        }
        return true;
    }

    /*
     * (non-Javadoc)
     * @see fr.marseille.permissionmanagement.dao.ClientDAO#findAll()
     */
    @Override
    public List<Client> findAll() throws DAOException {
        List<Client> clients = new ArrayList<>();
        try {
            clients = (List<Client>) entityManager.createQuery("from Client").getResultList();
        } catch (RuntimeException e) {
            String msg = "findAll : " + e.getMessage();
            LOG.warn(msg);
            JPAUtil.rollbackTransaction();
            throw new DAOException(msg, e);
        }
        return clients;
    }

    /*
     * (non-Javadoc)
     * @see fr.marseille.permissionmanagement.dao.ClientDAO#find(java.lang.Integer)
     */
    @Override
    public Client find(Integer id) throws DAOException {
        Client client = null;
        try {
            client = entityManager.find(Client.class, id);
        } catch (RuntimeException e) {
            String msg = "find : " + e.getMessage();
            LOG.warn(msg);
            JPAUtil.rollbackTransaction();
            throw new DAOException(msg, e);
        }
        return client;

    }

    /*
     * (non-Javadoc)
     * @see fr.marseille.permissionmanagement.dao.ClientDAO#update(fr.marseille.permissionmanagement.model.Client)
     */
    @Override
    public Client update(Client client) throws DAOException {
        try {
            JPAUtil.beginTransaction();
            entityManager.merge(client);
            JPAUtil.commitTransaction();
        } catch (RuntimeException e) {
            String msg = "update : " + e.getMessage();
            LOG.warn(msg);
            JPAUtil.rollbackTransaction();
            throw new DAOException(msg, e);
        }
        return client;

    }

    /*
     * (non-Javadoc)
     * @see fr.marseille.permissionmanagement.dao.ClientDAO#delete(java.lang.Integer)
     */
    @Override
    public boolean delete(Integer id) throws DAOException {
        Client client = this.find(id);
        if (null != client) {
            try {
                JPAUtil.beginTransaction();
                entityManager.remove(client);
                JPAUtil.commitTransaction();
            } catch (RuntimeException e) {
                String msg = "remove : " + e.getMessage();
                LOG.warn(msg);
                JPAUtil.rollbackTransaction();
                throw new DAOException(msg, e);
            }
        }
        return true;
    }

    @Override
    public void mask(Client client) throws DAOException {
        // TODO Auto-generated method stub

    }

    @Override
    public void mask(List<Client> clients) throws DAOException {
        for (Client client : clients) {
            this.mask(client);
        }

    }

    @Override
    public void autoriseNewsletter(Client client) throws DAOException {
        // TODO Auto-generated method stub

    }

    @Override
    public void refuseNewsletter(Client client) throws DAOException {
        // TODO Auto-generated method stub

    }

    @Override
    public String assignerCode() throws DAOException {
        Boolean codeDisponible = false;
        String codeGenere = "";
        
        do {
            codeGenere = this.genererCode();
            codeDisponible = this.verifierCode(codeGenere);                    
        } while (!codeDisponible);
        
        return codeGenere;
    }

    @Override
    public Boolean verifierCode(String code) throws DAOException {
        return !this.findAll().stream().anyMatch(c->c.getCode().equals(code));
    }

    @Override
    public String genererCode() throws DAOException {
        Random aleatoire = new Random();
        StringBuilder code = new StringBuilder();

        code.append(aleatoire.ints(10, 100).findFirst().getAsInt());
        code.append((char) aleatoire.ints(65, 91).findFirst().getAsInt());
        code.append((char) aleatoire.ints(65, 91).findFirst().getAsInt());
        code.append(aleatoire.ints(10, 100).findFirst().getAsInt());

        return code.toString();
    }

}