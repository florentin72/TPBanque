package model;

import java.util.List;

public class Client {
    private String nom;
    private List<Compte> listCompte;

    public Client(String nom) {
        this.nom = nom;
    }

    public Client() {
    }

    public List<Compte> getListCompte() {
        return listCompte;
    }

    public void setListCompte(List<Compte> listCompte) {
        this.listCompte = listCompte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


}
