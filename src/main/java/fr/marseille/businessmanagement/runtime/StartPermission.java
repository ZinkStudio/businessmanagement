package fr.marseille.businessmanagement.runtime;

import java.util.List;
import fr.marseille.businessmanagement.dao.impl.LanguageJPADAO;
import fr.marseille.businessmanagement.exception.DAOException;
import fr.marseille.businessmanagement.exception.ServiceException;
import fr.marseille.businessmanagement.model.Language;
import fr.marseille.businessmanagement.model.Permission;
import fr.marseille.businessmanagement.model.PermissionLabel;
import fr.marseille.businessmanagement.service.PermissionService;
import fr.marseille.businessmanagement.util.JPAUtil;

public class StartPermission {

    protected static String[] locales = {"en", "fr"};
    protected static String[] resources = {"home", "support", "adminpanel"};
    protected static String[] actions = {"create", "read", "update", "delete"};
    protected static String[] applications = {"cognava", "spotpulse", "sharelytic", "cloudovio"};
    protected static LanguageJPADAO languageDAO = new LanguageJPADAO();
    protected static PermissionService permissionService = new PermissionService();

    public static void main(String[] args) throws ServiceException, DAOException {

        insertPermissions();
        insertLanguages();
        localizePermissions();
        // JPAUtil.closeAll();
    }

    protected static void localizePermissions() throws ServiceException {
        List<Permission> permissions = permissionService.findAll();
        List<Language> languages = (List<Language>) JPAUtil.getEntityManager().createQuery("from Language")
                .getResultList();

        for (Permission permission : permissions) {
            String[] split = permission.getEntry().split("\\.");

            for (Language language : languages) {
                PermissionLabel label = new PermissionLabel();
                label.setLanguage(language);
                label.setPermission(permission);

                if ("en".equals(language.getLocale())) {
                    label.setLabel("allow to " + split[2] + " for resource " + split[1] + " from " + split[0]
                            + " application");
                } else if ("fr".equals(language.getLocale())) {
                    label.setLabel("permet de " + split[2] + " la ressource " + split[1] + " depuis l'application "
                            + split[0]);
                }

                JPAUtil.getEntityManager().getTransaction().begin();
                JPAUtil.getEntityManager().persist(label);
                JPAUtil.getEntityManager().getTransaction().commit();
            }
        }
    }

    protected static void insertPermissions() throws ServiceException, DAOException {

        for (String application : applications) {
            for (String resource : resources) {
                for (String action : actions) {
                    permissionService.save(new Permission(null, application + "." + resource + "." + action));
                }
            }
        }

    }

    protected static void insertLanguages() throws DAOException {

        for (String locale : locales) {
            boolean isDefault = false;

            if ("fr".equals(locale)) {
                isDefault = true;
            }

            languageDAO.save(new Language(locale, isDefault));

        }
    }

}
