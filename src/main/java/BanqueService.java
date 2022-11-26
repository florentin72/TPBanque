import model.Banque;
import model.Client;
import model.Compte;
import org.apache.commons.collections4.CollectionUtils;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class BanqueService {

    public void traiterAction(int action){
        Scanner scanner = new Scanner(new
                InputStreamReader(System.in));
        String nom;
        int montantCompte;
        switch (action){
            //ajout client
            case 1 :
                System.out.println("Nom du client ? ");
                 nom = scanner.nextLine();
                ajoutClient(nom);
                break;
            //ajout compte
            case 2 :
                System.out.println("Nom du client ? ");
                 nom = scanner.nextLine();
                System.out.println("montant du compte ? ");
                montantCompte = scanner.nextInt();
                ajoutCompteClient(nom,montantCompte);
                break;
            case 3 :
                afficherClient();
                break;

            default:
                throw new IllegalStateException("Aucune action " + action + " n'existe");
        }

    }

    private void afficherClient() {
        for (Client c : Banque.getBanque()){
            System.out.println(c.getNom());
        }
    }

    private void ajoutCompteClient(String nom, int montant) {
        Optional<Client> clientOptional = Banque.getBanque().stream().filter(c -> nom.equals(c.getNom())).findFirst();

        if (clientOptional.isPresent() ){
           Client client = clientOptional.get();

           if (CollectionUtils.isEmpty(client.getListCompte())){
               client.setListCompte(new ArrayList<>());
           }
           client.getListCompte().add(new Compte(montant));
       }

    }

    private void ajoutClient(String nom) {
        Client client = new Client(nom);
        Banque.getBanque().add(client);

    }
}
