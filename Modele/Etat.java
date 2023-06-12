package Modele;

import java.awt.*;
import java.util.*;

import Modele.Unite.*;
import Modele.Unite.Fleur.Type;



public class Etat {

    private final int largeur;
    private final int hauteur;

    private final int largeur_jardin = 20;
    private final int hauteur_jardin = 15;

    private final int batiment_x = 9;
    private final int batiment_y = 7;

    private final int nbJardinier = 3;
    private final int nbLapin = 5;

    private Jardin jardin;
    private Batiment batiment;
    private ArrayList<Jardinier> jardiniers = new ArrayList<>();
    private ArrayList<Fleur> fleurs = new ArrayList<>();
    private ArrayList<Lapin> lapins = new ArrayList<>();
    private ArrayList<Fleur> fleursRecolter = new ArrayList<>();
    private ArrayList<Fleur.Type> graines = new ArrayList();
    private ArrayList<Bouquet> bouquets = new ArrayList();
    private int argent = 200;
    private Message message;
    private final int taille_batiment = 2;


    /** Les coordonnées de la case sélectionnée */
    private Point caseSelected;

    /** Une case peut avoir plusieurs unités */
    private ArrayList<Unite> unitesSelected = new ArrayList<>();

    public Etat(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.jardin = new Jardin(hauteur_jardin, largeur_jardin);
        jardiniers.add(new Jardinier(this, new Point(5, 6)));
        //fleurs.add(new Fleur(this, new Point(6, 6), Type.ROSE));
        this.batiment = new Batiment(this, new Point(batiment_x, batiment_y), taille_batiment);

        graines.add(Type.ROSE);
        Timer timer = new Timer();
        timer.schedule(new LapinCreator(this), 0, 15000);
        }
    
    private class LapinCreator extends TimerTask {
        private final Random random = new Random();
        private Etat etat ;
        public LapinCreator(Etat etat) {
        	this.etat=etat;
        }
        public void run() {
            if (lapins.size() < nbLapin) {
                Lapin lapin = new Lapin(etat, new Point(random.nextInt(largeur_jardin), random.nextInt(hauteur_jardin)));
                etat.lapins.add(lapin);
            } else {
                cancel();
            }
        }
    }
    public int getHauteur() {
        return hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteurJardin() {
        return hauteur_jardin;
    }

    public int getLargeurJardin() {
        return largeur_jardin;
    }

    public int getBatiment_x() {
        return batiment_x;
    }

    public int getBatiment_y() {
        return batiment_y;
    }

    public ArrayList<Jardinier> getJardiniers() {
        return jardiniers;
    }

    public ArrayList<Lapin> getLapins(){
    	return lapins;
    }
    public ArrayList<Fleur> getFleurs() {
        return fleurs;
    }

    public Jardin getJardin() {
        return jardin;
    }


    public Batiment getBatiment() {
        return this.batiment;
    }


    public void selectionne(Point p){
        caseSelected = p;
        unitesSelected.clear();
        //System.out.println("Jardin : " + p.y + " " + p.x);
        /*System.out.println(getUnite(p));
        if(!unitesSelected.contains(getUnite(p))&& jardin[p.y][p.x] != null){
            unitesSelected.add(getUnite(p));
        }*/

        for (Fleur f : fleurs) {
            //System.out.println("Etat : position des Fleurs "+ f.getPosition().x + " " + f.getPosition().y);
            if(f.getPosition().x == p.getLocation().x && f.getPosition().y == p.getLocation().y){
                unitesSelected.add(f);
            }
        }

        for (Jardinier j : jardiniers) {
            //System.out.println("Etat : position des Jardinier "+ j.getPosition().x + " " + j.getPosition().y);
            if(j.getPosition().x == p.getLocation().x && j.getPosition().y == p.getLocation().y){
                unitesSelected.add(j);
            }
        }

        for (Lapin l : lapins) {
            //System.out.println("Etat : position des Lapins "+ l.getPosition().x + " " + l.getPosition().y);
            if(l.getPosition().x == p.getLocation().x && l.getPosition().y == p.getLocation().y){
                unitesSelected.add(l);
            }
        }

    }
    public void click(Point p) {
        this.selectionne(p);
        System.out.println("Etat : selected point check " + caseSelected.x + " " +caseSelected.y);
        System.out.println("Etat : il y a " +unitesSelected.size() + " unité(s)");
    }
    
    public ArrayList<Unite> getUnitesSelected(){
        return unitesSelected;
    }

    public Point getCaseSelected(){return caseSelected;}
    

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    /**
     * Teste s'il y a une fleur à la position p
     * @param position position
     * @return la fleur a la position p s'il y a, sinon null
     */
    public Fleur fleurPresent(Point position) {
        for (Fleur fleur : fleurs) {
            if (fleur.getPosition().equals(position))
                return fleur;
        }
        return null;
    }

/*
    public void removeFleur(Fleur f) {
        //System.out.println("Etat : " + f.getPosition().x + "" + fleurs.get(i).getPosition().y + " point selected: "+ p.x+"" +p.y);
        fleurs.remove(f);
        jardin.retireCase(f.getPosition());
    }
*/
    public ArrayList<Fleur> getFleursRecolter() {
        return fleursRecolter;
    }


    /**
     * Enlève une fleur récolter de la liste
     * @param type type de fleur a enlever
     * @return la fleur qui est enlevé s'il existe sinon null
     */
    public Fleur removeFleursRecolter(Type type) {
        for (int i = 0; i < fleursRecolter.size(); ++i) {
            if ((fleursRecolter.get(i)).getType() == type) {
                Fleur f = fleursRecolter.get(i);
                fleursRecolter.remove(i);
                return f;
            }
        }
        return null;
    }


    public int getNombreFleursRecolter(Fleur.Type type) {
        int n = 0;
        Iterator var3 = this.fleursRecolter.iterator();

        while (var3.hasNext()) {
            Fleur f = (Fleur) var3.next();
            if (f.getType() == type) {
                ++n;
            }
        }
        return n;
    }


    public ArrayList<Fleur.Type> getGraines() {
        return graines;
    }
    public int getNombreGraines(Fleur.Type type) {
        return (int) graines.stream()
                .filter(t -> t == type)
                .count();
    }



    public ArrayList<Bouquet> getBouquets() {
        return bouquets;
    }


    public int getArgent() {
        return argent;
    }

    public void ajouterArgent(int montant) {
        argent = argent + montant;
    }

    public void retireArgent(int montant) {
        argent -= montant;
    }
/*
    public void removeLapin(Lapin lapin){
        lapins.remove(lapin);
        jardin.retireCase(lapin.getPosition());
    }
*/
    public Lapin lapinPresent(Point position) {
        for (Lapin lapin: lapins) {
            if(lapin.getPosition().equals(position))
                return lapin;
        }
        return null;
    }

    public int getNbJardinier(){return nbJardinier;}


    public int getTaille_batiment(){return taille_batiment;}




    /**
     * Test s'il y a un jardinier
     * @param p la position
     * @return true si il y a un jardinier sur la case de position p
     * sinon false
     */
    public boolean jardinierPresent(Point p){
        for (Unite u : unitesSelected) {
            //System.out.println("UnitesSelected : " + u.getClass().getName()); 
            if(u.getClass().getName() == "Modele.Unite.Jardinier"){
                return true;
            }
        }
        return false;
    }

}