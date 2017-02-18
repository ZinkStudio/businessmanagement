package fr.marseille.businessmanagement.dao.impl;

import java.util.ArrayList;
import java.util.List;
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
    private static final Logger LOG = Logger.getLogger(ClientJPADAO.class);

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
            JPAUtil.getEntityManager().persist(client);
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
            clients = (List<Client>) JPAUtil.getEntityManager().createQuery("from Client").getResultList();
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
            client = JPAUtil.getEntityManager().find(Client.class, id);
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
            JPAUtil.getEntityManager().merge(client);
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
                JPAUtil.getEntityManager().remove(client);
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

}