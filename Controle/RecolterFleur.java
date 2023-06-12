package Controle;

import Modele.Etat;
import Modele.Unite.Fleur;
import Modele.Unite.Jardinier;
import Vue.VueBatiment;
import Vue.VueJardin;
import Vue.VueJardinier;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RecolterFleur implements MouseListener {

    private final Etat etat;
    private final VueJardin affichage;
    private final Jardinier jardinier;
    private final Fleur.Type typeFleur;

    public RecolterFleur(Etat etat, VueJardin affichage,Fleur.Type typeFleur) {
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
        System.out.println("RecolterFleur");
        if ( typeFleur == typeFleur.ROSE) {
            RecolterFleurRose();
        } else if (typeFleur == typeFleur.LYS) {
            RecolterFleurLys();;
        } else if (typeFleur == typeFleur.TULIPE) {
            RecolterFleurTulipe();
        }

    }

    private void RecolterFleurRose() {
        System.out.println("RecolterFleur   Rose");
        jardinier.recolter();
    }

    private void RecolterFleurLys() {
        System.out.println("RecolterFleur   Lys");
        jardinier.recolter();
    }

    private void RecolterFleurTulipe() {
        System.out.println("RecolterFleur   Tulipe");
        jardinier.recolter();
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
