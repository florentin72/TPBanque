package model;

import java.io.Serializable;

public class Client implements Serializable {
    private String nom;
    private String prenom;
    public Client(String prenom, String nom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Client() {
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
