package Controle;

import Modele.Etat;
import Modele.Unite.Fleur;
import Modele.Unite.Jardinier;
import Vue.VueBatiment;
import Vue.VueJardin;
import Vue.VueJardinier;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ProduireBouquet implements MouseListener {

    private final Etat etat;
    private final VueJardin affichage;
    private final Jardinier jardinier;
    private  Fleur.Type typeFleur;

    public ProduireBouquet(Etat etat, VueJardin affichage, Fleur.Type typeFleur) {
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
        System.out.println("ProduireBouquet");
        if ( typeFleur == Fleur.Type.ROSE) {
            ProduireBouquet_Rose();
        } else if (typeFleur == typeFleur.LYS) {
            ProduireBouquet_Lys();
        } else if (typeFleur == typeFleur.TULIPE) {
            ProduireBouquet_Tulipe();
        } else if (typeFleur == null) {
            ProduireBouquet_Mixte();
        }

    }

    private void ProduireBouquet_Mixte() {
        System.out.println("ProduireBouquet_Mixte");
        try {
            jardinier.produireBouquet(null);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void ProduireBouquet_Tulipe() {
        System.out.println("ProduireBouquet_Tulipe");
        jardinier.produireBouquet(Fleur.Type.TULIPE);
        try {
            jardinier.produireBouquet(Fleur.Type.TULIPE);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void ProduireBouquet_Lys() {
        System.out.println("ProduireBouquet_Lys");
        jardinier.produireBouquet(Fleur.Type.LYS);
        try {
            jardinier.produireBouquet(Fleur.Type.LYS);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void ProduireBouquet_Rose() {
        System.out.println("ProduireBouquet_Rose");
        jardinier.produireBouquet(Fleur.Type.ROSE);
        try {
            jardinier.produireBouquet(Fleur.Type.ROSE);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
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
