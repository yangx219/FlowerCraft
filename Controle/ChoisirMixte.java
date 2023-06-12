package Controle;

import Modele.*;

import Modele.Unite.Fleur;
import Modele.Unite.Jardinier;
import Vue.VueJardin;
import Vue.VueBatiment;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChoisirMixte implements MouseListener {

    private final Etat etat;
    private final VueJardin affichage;
    private final Jardinier jardinier;
    private final Fleur.Type typeFleur;

    public ChoisirMixte(Etat etat, VueJardin affichage) {
        this.etat = etat;
        this.affichage = affichage;
        this.typeFleur = null;
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
        System.out.println("ChoisirMixte");
        ProduireBouquet listener2 = new ProduireBouquet(etat, affichage, typeFleur);
        VueBatiment.addProduireBouquetListener(listener2);
        VendreBouquet listener3 = new VendreBouquet(etat, affichage, typeFleur);
        VueBatiment.addVendreBouquetListener(listener3);
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
