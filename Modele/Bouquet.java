package Modele;

import java.util.ArrayList;

import Modele.Unite.Fleur;

public class Bouquet {

    private ArrayList<Fleur> fleurs;
    private Type type;

    public enum Type{
        ROSE,
        LYS,
        TULIPE,
        MIXTES
    }

    public Bouquet(ArrayList<Fleur> fleurs, Type type) {
        this.fleurs = fleurs;
        this.type = type;
    }

    public ArrayList<Fleur> getFleurs() {
        return fleurs;
    }

    public Type getType() {
        return type;
    }
    
}
