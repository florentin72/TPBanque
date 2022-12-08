import com.google.gson.Gson;
import model.Client;
import model.Compte;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static Logger LOGGER = Logger.getLogger(Main.class);
    public static void main (String args[]){

      // org.apache.log4j.BasicConfigurator.configure();
        LOGGER.info("début de l'appli");
        BanqueService banqueService = new BanqueService();
        List<Compte> listComptes = new ArrayList<>();
        Client client = new Client("Ali","Gator");
        Client client2 = new Client("Gaspard","Alizan");
        LOGGER.debug("Ajout d'un Compte pour " + client.getPrenom() + " " + client.getNom());
        Compte compte = new Compte(1550,1,client);
        LOGGER.debug("Ajout d'un Compte pour " + client.getPrenom() + " " + client.getNom());
        Compte compte2 = new Compte(1000,2,client);
        LOGGER.debug("Ajout d'un Compte pour " + client.getPrenom() + " " + client.getNom());
        Compte compte3 = new Compte(150.50,3,client);

        LOGGER.debug("Ajout d'un Compte pour " + client2.getPrenom() + " " + client2.getNom());
        Compte compte4 = new Compte(1500000,4,client2);
        listComptes.add(compte);
        listComptes.add(compte2);
        listComptes.add(compte3);
        listComptes.add(compte4);
        banqueService.getCompteMax(listComptes);
        System.out.println(listComptes);
        LOGGER.info("trie des comptes");
        listComptes =banqueService.sortBySolde(listComptes);
        System.out.println(listComptes);
        //banqueService.addCompte(listComptes);
        Gson gson = new Gson();
        LOGGER.info("Affichage de la liste en json");
        System.out.println();

        try {
            banqueService.writeInFile(gson.toJson(listComptes));
        } catch (IOException e) {
            LOGGER.error("Fichier introuvable",e);
        }
        try {
            List<Compte> listFromFile = banqueService.getListFromFile("storage.json");

        } catch (IOException e) {
            LOGGER.error("Fichier introuvable",e);
        }
    }



}
