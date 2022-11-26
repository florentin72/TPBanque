package model;

import java.util.ArrayList;

public class Banque extends ArrayList<Client> {

    private  static Banque banque;

    private Banque(){

    }

    public static Banque getBanque(){
        if (banque == null){
            banque = new Banque();
        }
        return banque;
    }

}
