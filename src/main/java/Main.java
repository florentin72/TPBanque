import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main (String args[]){
        System.out.println("Welcome to my bank !! ");
        Scanner scanner = new Scanner(new
                InputStreamReader(System.in));
        int action = 0;
        BanqueService banqueService = new BanqueService();
        while(action != 5){
            System.out.println("Que voulez vous faire");
            System.out.println("1 : ajout client");
            System.out.println("2 : ajout d'un compte pour un client");
            System.out.println("3 : afficher la liste des clients");
            System.out.println("4 : trouver le client avec le  plus grand compte");
            System.out.println("5 : stop");

            //read a line using scanner object.
            action = scanner.nextInt();
            banqueService.traiterAction(action);
        }

    }



}
