import javax.swing.*;
import javax.swing.border.Border;

import Controle.Controlleur;

import java.awt.*;
import java.lang.ModuleLayer.Controller;
import java.util.ArrayList;

import Modele.Etat;
import Vue.*;

public class Main{
    public static final int largeur = 1000;
    public static final int hauteur = 800;


    public static void main(String[] args){
        Etat etat = new Etat(largeur, hauteur);
        Affichage affichage = new Affichage(etat);
        //Controlleur control = new Controlleur(etat, affichage.getVueJardin());
        


    }
}
