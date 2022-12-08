import com.fasterxml.jackson.databind.ObjectMapper;
import model.Banque;
import model.Client;
import model.Compte;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BanqueService {


    Scanner scanner =new Scanner(new
            InputStreamReader(System.in));

    ObjectMapper mapper = new ObjectMapper();

    /**
     *
     */
    private void afficherClient() {
        for (Client c : Banque.getBanque()){
            System.out.println(c.getNom());
        }
    }

    /**
     *
     * @param listComptes
     * @return
     */
    public List<Compte> sortBySolde(List<Compte> listComptes) {

        listComptes.sort((o1, o2) -> (int) (o1.getSolde() - o2.getSolde()));
        return listComptes;
       //return  listComptes.stream().sorted(Comparator.comparing(Compte::getSolde)).collect(Collectors.toList());
    }

    /**
     *
     * @param listCompte
     */
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

    /**
     *
     * @param listComptes
     * @throws IOException
     */
    public void writeInFile(String listComptes) throws IOException {
        FileWriter fileWriter = new FileWriter(new File("src/main/resources/storage.json"));
        fileWriter.write(listComptes);
        fileWriter.flush();
    }

    /**
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    public List<Compte> getListFromFile(String filePath) throws IOException {
      return   mapper.readValue(this.getClass().getResourceAsStream(filePath), LinkedList.class);

    }

    /**
     *
     * @param listComptes
     */
    public void getCompteMax(List<Compte> listComptes) {
        double maxSolde;
        Optional<Double> maxOpt = listComptes.stream().map(Compte::getSolde).max((o1, o2) -> (int) (o1 - o2));
        if (maxOpt.isPresent()){
            maxSolde =  maxOpt.get();
            Compte compte1 = listComptes.stream().filter(compte -> compte.getSolde() == maxSolde).findFirst().get();
        }

    }
}
