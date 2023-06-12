package Modele.Unite;

import java.awt.*;

import Modele.Etat;

public class Fleur extends Unite implements Runnable{

    public enum Type {ROSE, LYS, TULIPE}
    private int duree = 150;
    private Color couleur = Color.GREEN;
    private static final int TIMESTEP1 = 80;
    private static final int TIMESTEP2 = 50;
    private static final int TIMESTEP3 = 30;
    // pas encore ajoute des conditions pour type de fleur 
    private Type type;
    public Fleur(Etat e,Point position, Type t){
        super(position);
        this.type = t;
        e.getJardin().setCase(position, this);
        Thread th = new Thread(this);
        th.start();
    }

    @Override
    public void run(){
        while(duree > 0){
            duree--;
            if (duree < TIMESTEP1 && couleur == Color.GREEN){
                couleur = Color.YELLOW;
            } else if (duree < TIMESTEP2 && couleur == Color.YELLOW){
                couleur = Color.ORANGE;
            } else if (duree < TIMESTEP3 && couleur == Color.ORANGE){
                couleur = Color.RED;
            }

            try {   
                Thread.sleep(100);}
            catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }

    public int getDuree(){
        return duree;
    }

    public Color getCouleur(){
        return couleur;
    }


    public Type getType(){
        return type;
    }


}