package Modele.Unite;


import java.awt.*;
import java.util.Random;

import Modele.Bouquet;
import Modele.Etat;
import Modele.Message;
import Modele.Unite.Fleur.Type;

public class Jardinier extends Unite{

    private Etat etat;
    private boolean selected = false;

    public Jardinier(Etat e,Point position){
        super(position);
        this.etat=e;
        e.getJardin().setCase(position, this);
    }


    public void setSelected(boolean selected) {
    	this.selected = selected;;
    }
    public boolean isSelected() {
    	return selected;
    }


    /**
     * Teste si le jardinier est dans le bâtiment
     * @return true si la position du jardinier est a l'emplacement du bâtiment
     * sinon, false
     */
    private boolean estAuBatiment(){
        return this.etat.getBatiment().getPositions().contains(this.position);
    }


    /**
     * Plante une fleur dans le jardin si le jardinier est sur une zone libre
     * et qu'il y a des graines en stock
     * @param type type de fleur a planter
     */
    public void planter(Type type) {
        if (estAuBatiment()) {
            this.etat.setMessage(new Message("Impossible de planter sur le bâtiment", this.etat));
        } else if (this.etat.fleurPresent(this.position) != null) {
            this.etat.setMessage(new Message("Une fleur est déjà planter", this.etat));
        } else {
            Fleur.Type graine = null;

            for(int i = 0; i < this.etat.getGraines().size(); ++i) {
                if ((this.etat.getGraines().get(i)) == type) {
                    graine = this.etat.getGraines().get(i);
                    this.etat.getFleurs().add(new Fleur(etat, position, type));
                    this.etat.getGraines().remove(graine);
                }
            }

            if (graine == null) {
                this.etat.setMessage(new Message("Vous n'avez pas de graine de " + type, this.etat));
            }
        }

    }

    /**
     * Récolter une fleur a la position du jardinier s'il y en a
     */
    public void recolter() {
        Fleur f = this.etat.fleurPresent(this.position);
        if (f == null) {
            this.etat.setMessage(new Message("Il n'y a pas de fleur a récolter ", this.etat));
        } else if (f.getDuree() <= 0) {
            f.setPosition((Point)null);
            this.etat.getFleursRecolter().add(f);
            this.etat.getFleurs().remove(f);
            this.etat.getJardin().retireCase(f.getPosition());
            this.etat.setMessage(new Message(f.getType() + " est récolté", this.etat));
        } else {
            this.etat.setMessage(new Message("La fleur n'est pas prêt a être récolter", this.etat));
        }

    }


    /**
     * Achète des graines au bâtiment si on a assez d'argent
     * @param type type de graine a acheter
     * @param n quantité de graine a acheter
     */
    public void acheterGraines(Type type, int n) {

        if (!estAuBatiment()) {
            this.etat.setMessage(new Message("Il faut se rendre au bâtiment pour acheter des graines", this.etat));
        } else {
            int prix = etat.getBatiment().prixGraines(type, n);
            if (prix > 0) {
                for(int i=0; i<n;i++){
                    this.etat.getGraines().add(type);
                }
                this.etat.getGraines().add(type);
                this.etat.retireArgent(prix);
                this.etat.setMessage(new Message(type + " acheté", this.etat));
            }
        }
    }


    /**
     * Chasse un lapin a la position du jardinier s'il y en a
     */
    public void chasserLapin() {
        Lapin lapin = this.etat.lapinPresent(this.position);
        if (lapin != null) {
            etat.getLapins().remove(lapin);
            etat.getJardin().retireCase(lapin.getPosition());
            //this.etat.removeLapin(lapin);
            this.etat.setMessage(new Message("Lapin chasser", this.etat));
        } else {
            this.etat.setMessage(new Message("Il n'y a pas de lapin a chasser", this.etat));
        }

    }

    /**
     * Le jardinier vend un bouquet de fleur au bâtiment si il ya en stock
     */
    public void vendreBouquet() {
        if (!estAuBatiment()) {
            this.etat.setMessage(new Message("Il faut se rendre au bâtiment pour vendre vos bouquet", this.etat));
        } else if (this.etat.getBouquets().size() == 0) {
            this.etat.setMessage(new Message("Vous n'avez pas de bouquet a vendre", this.etat));
        } else {
            Bouquet bouquet = (Bouquet)this.etat.getBouquets().get(0);
            int prix = etat.getBatiment().prixBouquet( bouquet);
            this.etat.getBouquets().remove(bouquet);
            this.etat.ajouterArgent(prix);
            this.etat.setMessage(new Message("Bouquet vendu a un prix de " + prix, this.etat));
        }

    }

    /**
     * Produire un bouquet de fleur au batiment
     * @param type type du bouquet
     */
    public void produireBouquet(Fleur.Type type){
        if (!estAuBatiment()) {
            this.etat.setMessage(new Message("Il faut se rendre au bâtiment pour vendre produire des bouquets", this.etat));
        }else{
            etat.getBatiment().produireBouquet(type);
        }
    }

    /**
     * Recrute un jardinier au batiment
     */
    public void recruterJardinier() {
        if (!estAuBatiment()) {
            this.etat.setMessage(new Message("Il faut se rendre au bâtiment pour recruter un jardinier", this.etat));
        }
        else if(this.etat.getJardiniers().size()==this.etat.getNbJardinier()){
            this.etat.setMessage(new Message("Nombre de jardinier limité a "+ etat.getNbJardinier(), this.etat));
        }
        else if (this.etat.getArgent() < 200) {
            this.etat.setMessage(new Message("Vous n'avez pas atteint le niveau pour recruter un jardinier", this.etat));
        }
        else {
            Random random = new Random();
            int x = random.nextInt(this.etat.getLargeurJardin() - 1);
            int y = random.nextInt(this.etat.getHauteurJardin() - 1);
            Point p = new Point(x, y);
            this.etat.getJardiniers().add(new Jardinier(this.etat,p));
        }

    }

}
