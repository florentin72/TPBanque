package model;

public class Compte {
    private int solde;

    public Compte(int solde) {
        this.solde = solde;
    }

    public Compte() {
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }
}
