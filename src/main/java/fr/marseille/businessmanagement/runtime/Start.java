package fr.marseille.businessmanagement.runtime;

import fr.marseille.businessmanagement.exception.DAOException;
import fr.marseille.businessmanagement.exception.ServiceException;
import fr.marseille.businessmanagement.runtime.Start.MODE;
import fr.marseille.businessmanagement.util.JPAUtil;

public class Start {

    public enum MODE {
        /**
         * CREATE MODE
         */
        CREATE,
        /**
         * UPDATE MODE
         */
        UPDATE;
    }

    // public static MODE mode = MODE.CREATE;
    public static MODE mode = MODE.UPDATE;

    public static void main(String[] args) throws ServiceException, DAOException {

        if (mode.equals(MODE.CREATE)) {
            generateDatabase();
        } else {
            StartUser.main(args);
            StartPermission.main(args);
            StartProfile.main(args);
        }

        JPAUtil.closeAll();

    }

    public static void generateDatabase() {
        JPAUtil.beginTransaction();
        JPAUtil.commitTransaction();
    }

}
