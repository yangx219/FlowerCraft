package Controle;

import Modele.*;
import Modele.Unite.Fleur;
import Modele.Unite.Jardinier;
import Vue.AStar;
import Vue.Affichage;
import Vue.VueJardin;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controlleur implements ActionListener, MouseListener{
    private Etat etat;
    private VueJardin affichage;
    private Affichage a;
    //private AStar aStar;
    public Point start = null;
    public Point target = null;

    public Controlleur(Etat etat, VueJardin affichage, Affichage a) {
        this.etat = etat;
        this.affichage = affichage;
        this.a = a;
        //this.aStar = new AStar(affichage.matrix);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Jardinier jardinier = etat.getJardiniers().get(0);
        switch (e.getActionCommand()) {
            case "Chasser lapin":
                jardinier.chasserLapin();
                break;
            case "Recruter jardiner":
                jardinier.recruterJardinier();
                break;

        }


    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        /** PROBLÈME */
        int y = e.getY()-30;

        if (x > 0 && x < etat.getLargeurJardin()*affichage.getLargeurCase()
        && y > 0 && y < etat.getHauteurJardin()*affichage.getHauteurCase()){
            etat.click(new Point(x/affichage.getLargeurCase(), y/affichage.getHauteurCase()));

            Point click = new Point(x/affichage.getLargeurCase(), y/affichage.getHauteurCase());
            Jardinier j = etat.getJardiniers().get(0);
            
            if(click.x  == j.getPosition().x && click.y == j.getPosition().y){
                if(!j.isSelected()){
                    j.setSelected(true);
                    start = click;
                    //System.out.println("start check");
                }else{
                    j.setSelected(false);
                }
            }
            if(j.isSelected() && click != start && click != null){
                target = click;
                affichage.setTargetPosition(target);
            }


            if(j.isSelected() && target != null && target != start){
                AStar aStar = new AStar(etat.getJardin());
                /**
                for(int i=0;i<etat.getBatiment().positions.size();i++) {
                	aStar.setNodeValue(etat.getBatiment().positions.get(i).y,etat.getBatiment().positions.get(i).x,1);

                	}*/
                aStar.drawShortestPath(start.y, start.x, target.y, target.x);
                //System.out.println("Controlleur : start" + start.x +"," +start.y + " target :" + target.x +", "+ target.y) ;
                affichage.aStar = aStar;
                //j.setSelected(false);
            }

            a.uniteInterface();

            


            

            
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}

