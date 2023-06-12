package Controle;


import Modele.Etat;
import Modele.Unite.Fleur;
import Modele.Unite.Jardinier;
import Vue.VueJardin;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AcheterGraines implements MouseListener {

    private final Etat etat;
    private final VueJardin affichage;
    private final Jardinier jardinier;
    private final Fleur.Type typeFleur;

    public AcheterGraines(Etat etat, VueJardin affichage, Fleur.Type typeFleur) {
        this.etat = etat;
        this.affichage = affichage;
        this.typeFleur = typeFleur;
        this.jardinier = etat.getJardiniers().get(0);
    }



    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("AcheterGraines");
        if ( typeFleur == typeFleur.ROSE) {
            AcheterRoseGraines();
        } else if (typeFleur == typeFleur.LYS) {
            AcheterLysGraines();
        } else if (typeFleur == typeFleur.TULIPE) {
            AcheterTulipeGraines();
        }

    }

    private void AcheterTulipeGraines() {
        System.out.println("AcheterGraines  Tulipe ");
        jardinier.acheterGraines(Fleur.Type.TULIPE, 1);
    }

    private void AcheterLysGraines() {
        System.out.println("AcheterGraines  Lys ");
        jardinier.acheterGraines(Fleur.Type.LYS, 1);
    }

    private void AcheterRoseGraines() {
        System.out.println("AcheterGraines  Rose ");
        jardinier.acheterGraines(Fleur.Type.ROSE, 1);
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
