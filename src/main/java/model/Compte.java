package model;

import java.io.Serializable;

public class Compte implements Serializable {
    private double solde;
    private int numeroCompte;
    private Client client;

    public Compte(double solde, int numeroCompte, Client client) {
        this.solde = solde;
        this.numeroCompte = numeroCompte;
        this.client = client;
    }


    public Compte(){

    }


    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public int getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(int numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString(){
        return "Compte numéro " + this.numeroCompte + " appartient à " + this.client.getPrenom() + " " + this.client.getNom() + " solde de : " + this.solde + "\n";
    }
}
