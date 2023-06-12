package Controle;

import Modele.Etat;
import Modele.Unite.Fleur;
import Modele.Unite.Jardinier;
import Vue.VueBatiment;
import Vue.VueJardin;
import Vue.VueJardinier;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class PlanterFleur implements MouseListener {

    private final Etat etat;
    private final VueJardin affichage;
    private final Jardinier jardinier;
    private static Fleur.Type typeFleur = null;

    public PlanterFleur(Etat etat, VueJardin affichage,Fleur.Type typeFleur) {
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

        System.out.println("Planter Fleur");
        if ( getSelectedType() == typeFleur.ROSE) {
            PlanterFleurRose();
        } else if (getSelectedType() == typeFleur.LYS) {
            PlanterFleurLys();
        } else if (getSelectedType() == typeFleur.TULIPE) {
            PlanterFleurTulipe();
        }

    }

    private void PlanterFleurTulipe() {
        System.out.println("PlanterFleurTulipe");
        jardinier.planter(Fleur.Type.TULIPE);
    }

    private void PlanterFleurLys() {
        System.out.println("PlanterFleurLys");
        jardinier.planter(Fleur.Type.LYS);
    }

    private void PlanterFleurRose() {
        System.out.println("PlanterFleurRose");
        jardinier.planter(Fleur.Type.ROSE);
    }
    public static Fleur.Type getSelectedType() {
        if (typeFleur != null) {
            return typeFleur;
        } else {
            return null;
        }
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
