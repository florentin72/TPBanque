import model.Banque;
import model.Client;
import model.Compte;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BanqueService {


    Scanner scanner =new Scanner(new
            InputStreamReader(System.in));

    private void afficherClient() {
        for (Client c : Banque.getBanque()){
            System.out.println(c.getNom());
        }
    }


    public List<Compte> sortBySolde(List<Compte> listComptes) {
       return  listComptes.stream().sorted(Comparator.comparing(Compte::getSolde)).collect(Collectors.toList());
    }

    public void addCompte(List<Compte> listCompte) {

        if (listCompte == null) {
            listCompte = new ArrayList<>();
        }
        System.out.println("Nom du client ? ");
        String nom = scanner.nextLine();
        System.out.println("prenom du client ? ");
        String prenom = scanner.nextLine();

        System.out.println("numero du compte ? ");
        int numeroComtpe = scanner.nextInt();

        System.out.println("solde du compte ? ");
        double solde = scanner.nextDouble();

        listCompte.add(new Compte(solde,numeroComtpe, new Client(prenom,nom))) ;

    }
}
