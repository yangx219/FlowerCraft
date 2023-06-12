package Modele.Unite;

import java.awt.*;
import java.util.ArrayList;

import Modele.Bouquet;
import Modele.Etat;
import Modele.Bouquet.Type;
import Modele.Message;

public class Batiment extends Unite {

    private int graines_rose_dispo = 100;
    private int graines_lys_dispo = 100;
    private int graines_tulipe_dispo = 100;
    private int prix_graine = 3;
    private int prix_bouquet_meme = 10;
    private int prix_bouquet_different = 15;
    public ArrayList<Point> positions = new ArrayList();
    private Etat etat;


    public Batiment(Etat e, Point position,int taille) {
        super(position);
        etat=e;
        for(int i = 0; i < taille; ++i) {
            for(int j = 0; j < taille; ++j) {
                Point p = new Point(position.x + i, position.y + j);
                this.positions.add(p);
                e.getJardin().setCase(p, this);
            }
        }
    }

    /**
     * Vends des graines au prix fixe
     * @param type le type de graines qu'il veut acheter
     * @param n    le nombre de graines qu'il veut acheter
     * @return true si la transaction a été effectuée, false sinon
     */
    public int prixGraines( Fleur.Type type, int n) {
        int prix = n * prix_graine;
        if (etat.getArgent() < prix) {
            return 0;
        }
        switch (type) {
            case ROSE:
                if (graines_rose_dispo < n) {
                    etat.setMessage(new Message("Il n'y a plus de graine de rose en stock",etat));
                    return 0;
                }
                graines_rose_dispo -= n;
                break;
            case LYS:
                if (graines_lys_dispo < n) {
                    etat.setMessage(new Message("Il n'y a plus de graine de lys en stock",etat));
                    return 0;
                }
                graines_lys_dispo -= n;
                break;
            case TULIPE:
                if (graines_tulipe_dispo < n) {
                    etat.setMessage(new Message("Il n'y a plus de graine de tulipe en stock",etat));
                    return 0;
                }
                graines_tulipe_dispo -= n;
                break;
            default:
                etat.setMessage(new Message("erreur",etat));
                return 0;
        }
        return prix;
    }

    /**
     * Achete un bouquet de fleurs à un jardinier
     * @param bouquet le bouquet qu'il veut vendre
     * @return true si la transaction a été effectuée, false sinon
     */
    public int prixBouquet( Bouquet bouquet){
        int prix;
        ArrayList<Bouquet> bouquets_achat = new ArrayList<>();
        if(bouquet.getType() == Bouquet.Type.MIXTES){
            prix = prix_bouquet_meme;
        } else {
            prix = prix_bouquet_different;
        }
        bouquets_achat.add(bouquet);
        return prix;
    }



    /**
     * Méthode permettant de produire un bouquet de fleurs.
     * @param type Type de fleur souhaité pour le bouquet. Si aucun type n'est spécifié, le bouquet sera composé de fleurs de toutes les variétés.
     * @return Le bouquet produit. Retourne null si le jardinier n'a pas suffisamment de fleurs pour produire le bouquet.
     * */
    public Bouquet produireBouquet(Fleur.Type type){
        ArrayList<Fleur> fleurs = new ArrayList<>();
        Bouquet.Type bouquetType = null;
        if(type == null){
            if(etat.getNombreFleursRecolter(Fleur.Type.ROSE) < 1 || etat.getNombreFleursRecolter(Fleur.Type.LYS) < 1 || etat.getNombreFleursRecolter(Fleur.Type.TULIPE) < 1){
                etat.setMessage(new Message("Vous n'avez pas assez de fleur pour produire un bouquet",etat));
                return null;
            }
            fleurs.add(etat.removeFleursRecolter(Fleur.Type.ROSE));
            fleurs.add(etat.removeFleursRecolter(Fleur.Type.LYS));
            fleurs.add(etat.removeFleursRecolter(Fleur.Type.TULIPE));
            bouquetType = Bouquet.Type.MIXTES;
            etat.setMessage(new Message("Bouquet de fleur mixe bien produite",etat));
        } else {
            switch(type){
                case ROSE:
                    if(etat.getNombreFleursRecolter(Fleur.Type.ROSE) < 3){
                        etat.setMessage(new Message("Vous n'avez pas assez de rose pour produire un bouquet",etat));
                        return null;
                    }
                    for(int i = 0; i < 3; i++){
                        fleurs.add(etat.removeFleursRecolter(Fleur.Type.ROSE));
                    }
                    bouquetType = Bouquet.Type.ROSE;
                    etat.setMessage(new Message("Bouquet de rose bien produite",etat));
                    break;
                case LYS:
                    if(etat.getNombreFleursRecolter(Fleur.Type.LYS) < 3){
                        etat.setMessage(new Message("Vous n'avez pas assez de lys pour produire un bouquet",etat));
                        return null;
                    }
                    for(int i = 0; i < 3; i++){
                        fleurs.add(etat.removeFleursRecolter(Fleur.Type.LYS));
                    }
                    bouquetType = Bouquet.Type.LYS;
                    etat.setMessage(new Message("Bouquet de lys bien produite",etat));
                    break;
                case TULIPE:
                    if(etat.getNombreFleursRecolter(Fleur.Type.TULIPE) < 3){
                        etat.setMessage(new Message("Vous n'avez pas assez de tulipe pour produire un bouquet",etat));
                        return null;
                    }
                    for(int i = 0; i < 3; i++){
                        fleurs.add(etat.removeFleursRecolter(Fleur.Type.TULIPE));
                    }
                    bouquetType = Bouquet.Type.TULIPE;
                    etat.setMessage(new Message("Bouquet de tulipe bien produite",etat));
                    break;
            }
        }
        Bouquet bouquet = new Bouquet(fleurs, bouquetType);
        etat.getBouquets().add(bouquet);
        return bouquet;
    }


    public ArrayList<Point> getPositions() {
        return this.positions;
    }


}
