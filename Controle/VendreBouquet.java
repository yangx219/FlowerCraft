package Controle;

import Modele.Etat;
import Modele.Unite.Fleur;
import Modele.Unite.Jardinier;
import Vue.VueJardin;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VendreBouquet implements MouseListener {

    private final Etat etat;
    private final VueJardin affichage;
    private final Jardinier jardinier;
    private final Fleur.Type typeFleur;

    public VendreBouquet(Etat etat, VueJardin affichage, Fleur.Type typeFleur) {
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
        System.out.println("VendreBouquet");
        if ( typeFleur == Fleur.Type.ROSE) {
            VendreBouquet_Rose();
        } else if (typeFleur == Fleur.Type.LYS) {
            VendreBouquet_Lys();
        } else if (typeFleur == Fleur.Type.TULIPE) {
            VendreBouquet_Tulipe();
        } else if (typeFleur == null) {
            VendreBouquet_Mixte();
        }

    }

    private void VendreBouquet_Rose() {
        System.out.println("VendreBouquet  Rose");
        jardinier.vendreBouquet();
    }

    private void VendreBouquet_Lys() {
        System.out.println("VendreBouquet");
        jardinier.vendreBouquet();
    }

    private void VendreBouquet_Tulipe() {
        System.out.println("VendreBouquet    Lys");
        jardinier.vendreBouquet();
    }

    private void VendreBouquet_Mixte() {
        System.out.println("VendreBouquet   Mixte");
        jardinier.vendreBouquet();
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
