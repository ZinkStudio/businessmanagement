package fr.marseille.businessmanagement.runtime;

import java.util.Random;
import fr.marseille.businessmanagement.enumerated.Civilite;
import fr.marseille.businessmanagement.exception.ServiceException;
import fr.marseille.businessmanagement.model.Client;
import fr.marseille.businessmanagement.service.ClientService;
import fr.marseille.businessmanagement.util.JPAUtil;

public class StartClient {

    protected static String[] noms = {"Martin", "Bernard", "Thomas", "Petit", "Durand", "Dubois",
        "Moreau", "Lefebvre", "Fournier", "Bonnet", "Dupont", "Rousseau", "Lemaire", "Barbier", "Jacquet"};
    protected static String[] hommes = {"Pierre", "Albert", "Julien", "Jerome", "Fabrice", "Franck",
        "Damien", "Gerard"};
    protected static String[] femmes = {"Murielle", "Louise", "Lucie", "Justine", "Stephanie", "Laura",
        "Karine", "Jessica"};
    protected static String[] villes = {"Paris:75000:0140", "Marseille:13000:0491", "Lyon:69000:0472",
        "Nantes:44000:0240", "Toulon:83000:0494", "Caen:14000:0231", "Strasbourg:67000:0388",
        "Bordeaux:33000:0556"};

    protected static String[] commentaires = {"le CAC 40 néglige complètement les produits dérivés du nucléaire",
        "Zuckerberg ne connait pas plus que toi les récentes études du M.I.T",
        "c'est une réaction typique du mec qui ne sort pas beaucoup de chez lu",
        "l'accès démocratisé à l'information"};

    protected static ClientService clientService = new ClientService();

    public static void main(String[] args) throws ServiceException {
        JPAUtil.beginTransaction();
        insertClients();
        JPAUtil.closeAll();

    }

    protected static void insertClients() throws ServiceException {
        Random rng = new Random();
        for (String nom : noms) {
            for (String homme : hommes) {
                String email = nom + "." + homme + rng.nextInt(16) + "@gmail.com";

                String[] secteur = villes[rng.nextInt(villes.length)].split(":");

                String fixe = secteur[2];

                String mobile = "06";

                for (int i = 0; i < 8; i++) {
                    if (i < 6) {
                        fixe += rng.nextInt(9);
                    }
                    mobile += rng.nextInt(9);
                }

                clientService.save(new Client(null, nom, homme, Civilite.monsieur, fixe, mobile, email, commentaires[rng.nextInt(commentaires.length)]));
            }

            for (String femme : femmes) {
                String email = nom + "." + femme + rng.nextInt(16) + "@gmail.com";

                String[] secteur = villes[rng.nextInt(villes.length)].split(":");

                String fixe = secteur[2];

                String mobile = "06";

                for (int i = 0; i < 8; i++) {
                    if (i < 6) {
                        fixe += rng.nextInt(9);
                    }
                    mobile += rng.nextInt(9);
                }

                clientService.save(new Client(null, nom, femme, Civilite.madame, fixe, mobile, email, commentaires[rng.nextInt(commentaires.length)]));
            }
        }

    }
}
