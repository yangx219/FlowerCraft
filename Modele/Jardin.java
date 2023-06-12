package Modele;

import java.awt.*;
import java.util.ArrayList;

import Modele.Unite.Unite;
public class Jardin {

    /** Taille de la partie "jardin" */
    private final int largeur;
    private final int hauteur;

    private Unite[][] jardin;

    public Jardin(int hauteur, int largeur){
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.jardin = new Unite[hauteur][largeur];

        init_jardin();
    }

    /**
    * initialise toutes les cases dans le tableau
    */

    public void init_jardin(){
        for(int i = 0; i < this.jardin.length; i++){
            for(int j = 0; j < this.jardin[0].length; j++){
                jardin[i][j] = null;
            }
        }
    }

    public int getLargeur(){ return largeur;}

    public int getHauteur(){ return hauteur;}

    public void setCase(Point p, Unite u){
        jardin[p.y][p.x] = u;
    }

    public void retireCase(Point p){
        if(p != null){
            jardin[p.y][p.x] = null;
        }
    }

    public boolean estOccupee(Point p){
        return jardin[p.x][p.y] != null;
    }

    public Unite[][] getJardin(){return jardin;}

    /**
     * renvoyer la liste des points qui sont les voisins de Point p
     * @param p
    */
    public ArrayList<Point> getVoisins(Point p){
        int x = p.x;
        int y = p.y;
        ArrayList<Point> res = new ArrayList<>();
        for(int i = x-1; i <= x+1; i++){
            for(int j = y-1; j <= y+1; j++){
                if((i != x && j == y) || (j != y && i ==x)){
                    if (i >= 0 && i < largeur && j >= 0 && j < largeur){
                        res.add(new Point(i,j));
                    }
                }
            }
        }
        return res;
    }


    /*public Point getCaseSelected(){return caseSelected;}

    public ArrayList<Unite> getUnitesSelected(){return unitesSelected;}

    public Unite getUnite(Point p){
        if(jardin[p.y][p.x] != null) return jardin[p.y][p.x];
        else return null;
    }

    public void selectionne(Point p){
        caseSelected = p;
        unitesSelected.clear();
        //System.out.println("Jardin : " + p.y + " " + p.x);
        System.out.println(getUnite(p));
        if(!unitesSelected.contains(getUnite(p))&& jardin[p.y][p.x] != null){
            unitesSelected.add(getUnite(p));
        }
    }*/

}