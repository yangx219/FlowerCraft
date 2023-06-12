package Vue;
import Modele.*;
import Modele.Unite.Fleur;
import Modele.Unite.Jardinier;
import Modele.Unite.Lapin;
import Vue.AStar.Node;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;



public class VueJardin extends JPanel{

    private Etat etat;
    //public final static int taille_case = 40;
    public int[][] matrix;
    protected Point targetPosition = null;
    public AStar aStar;


    public VueJardin(Etat e){
        this.etat = e;

        setPreferredSize(new Dimension(etat.getLargeur(), etat.getHauteur()));


        matrix = new int[etat.getLargeurJardin()][etat.getHauteurJardin()];
        ReAffichage reAffichage = new ReAffichage(this);
        reAffichage.start();


    }

    /**
     * Dessine le jardin sur la fenetre du jeu
     *
     * @param g         Le contexte graphique à utiliser pour dessiner.
     */

    public void dessineJardin(Graphics g){
        /*
        Image image1 = null;
        Image image2 = null;
        try {
            image1 = ImageIO.read(new File("resources/Terre/terre1.png"));
            image2 = ImageIO.read(new File("resources/Terre/terre1.png"));
        }
        catch (IOException E) { E.printStackTrace(); }
    */



        int taille_case_x = getWidth() / etat.getLargeurJardin();
        int taille_case_y = getHeight() / etat.getHauteurJardin();

        for(int i = 0; i < etat.getHauteurJardin(); i++){
            for(int j = 0; j < etat.getLargeurJardin(); j++){
                /*if((i+j)%2==0){
                    g.drawImage(image1,j*taille_case_x, i*taille_case_y, taille_case_x, taille_case_y, null);
                }else {
                    g.drawImage(image2,j*taille_case_x, i*taille_case_y, taille_case_x, taille_case_y, null);
                }*/
                g.setColor(Color.BLACK);
                g.drawRect(j*taille_case_x, i*taille_case_y, taille_case_x, taille_case_y);
            }
        }


    }

    /**
     * Dessine un bâtiment sur la carte.
     *
     * @param g         Le contexte graphique à utiliser pour dessiner.
     */
    public void dessineBatiment(Graphics g) {
        URL batiment = getClass().getResource("/resources/batiment.png");
        ImageIcon batimentIcon = new ImageIcon(batiment);
        Image image = batimentIcon.getImage();
        int x = etat.getBatiment_x();
        int y = etat.getBatiment_y();
        int taille_case_x = getWidth() / etat.getLargeurJardin();
        int taille_case_y = getHeight() / etat.getHauteurJardin();
        int taille = etat.getTaille_batiment();
        // Dessine le bâtiment comme un carré de 4 cases
        g.drawImage(image,x * taille_case_x, y * taille_case_y,taille * taille_case_x, taille * taille_case_y,null);
    }



    public void dessineJardinier(Graphics g){
        URL url5 = getClass().getResource("/resources/jardinier1.png");
        ImageIcon userIcon5 = new ImageIcon(url5);
        Image image5 = userIcon5.getImage();
        URL url6 = getClass().getResource("/resources/jardinier0.png");
        ImageIcon userIcon6 = new ImageIcon(url6);
        Image image6 = userIcon6.getImage();

        ArrayList<Jardinier> jardiniers = etat.getJardiniers();
        int nbJardiniers = etat.getJardiniers().size();
        for(int i=0;i<nbJardiniers;i++){
            Jardinier jardinier = jardiniers.get(i);
            int x = jardiniers.get(i).getPosition().x;
            int y = jardiniers.get(i).getPosition().y;
            int taille_case_x = getWidth() / etat.getLargeurJardin();
            int taille_case_y = getHeight() / etat.getHauteurJardin();
            //System.out.println("VueJardinier : test " + jardinier.isSelected());
            if(jardinier.isSelected()) {
                //g.setColor(Color.DARK_GRAY);
                g.drawImage(image5,x*taille_case_x,y*taille_case_y,taille_case_x,taille_case_x,null);
                //g.fillOval(x*taille_case_x + (taille_case_x/4), y*taille_case_y + (taille_case_y/4), taille_case_x/2, taille_case_y/2);

                if(aStar != null && aStar.arrayList.size() > 0){
                    if(jardinier.getPosition() != new Point(aStar.arrayList.get(0).getY(),aStar.arrayList.get(0).getX())){
                        deplacementJardinier(jardinier);
                    }
                }
            }else {
                //g.setColor(Color.ORANGE);
                g.drawImage(image6,x*taille_case_x,y*taille_case_y,taille_case_x,taille_case_x,null);
                //g.fillOval(x*taille_case_x + (taille_case_x/4), y*taille_case_y + (taille_case_y/4), taille_case_x/2, taille_case_y/2);
            }
        }
    }
    public void dessinerouteLapin(Graphics g) {
        ArrayList<Lapin> lapins = etat.getLapins();
        ArrayList<Fleur> fleurs = etat.getFleurs();
        int nbLapins = lapins.size();
        int nbFleurs = fleurs.size();

        for (int i = 0; i < nbLapins; i++) {
            Lapin lapin = lapins.get(i);
            Point lapinPosition = lapin.getPosition();
            Fleur targetFleur = null;
            int shortestDistance = Integer.MAX_VALUE;

            for (int j = 0; j < nbFleurs; j++) {
                Fleur fleur = fleurs.get(j);
                Point fleurPosition = fleur.getPosition();
                int distance = Math.abs(lapinPosition.x - fleurPosition.x) + Math.abs(lapinPosition.y - fleurPosition.y);
                if (distance < shortestDistance) {
                    boolean isLapinAround = false;
                    for (Lapin otherLapin : lapins) {
                        if (otherLapin != lapin) {
                            Point otherLapinPosition = otherLapin.getPosition();
                            if (Math.abs(fleurPosition.x - otherLapinPosition.x) <= 1 && Math.abs(fleurPosition.y - otherLapinPosition.y) <= 1) {
                                isLapinAround = true;
                                break;
                            }
                        }
                    }
                    if (!isLapinAround) {
                        shortestDistance = distance;
                        targetFleur = fleur;
                        if (Math.abs(lapinPosition.x - fleurPosition.x) <= 1 && Math.abs(lapinPosition.y - fleurPosition.y) <= 1) {
                            Timer timer = new Timer(10000, (ActionListener) new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    etat.getJardin().retireCase(fleur.getPosition());
                                    etat.getFleurs().remove(fleur);
                                }
                            });
                            timer.setRepeats(false);
                            timer.start();
                        }
                    }
                }
            }

            if (targetFleur != null) {
                Point targetFleurPosition = targetFleur.getPosition();
                int dx = Math.abs(lapinPosition.x - targetFleurPosition.x);
                int dy = Math.abs(lapinPosition.y - targetFleurPosition.y);
                if (dx <= 1 && dy <= 1) {
                    continue;
                }
                AStar aStar1 = new AStar(etat.getJardin());
                ArrayList<AStar.Node> path = aStar1.drawShortestPath(lapinPosition.y, lapinPosition.x, targetFleur.getPosition().y, targetFleur.getPosition().x);
                if (path.size() > 1) {
                    Point nextPosition = new Point(path.get(path.size() - 2).getY(), path.get(path.size() - 2).getX());

                    Timer timer = new Timer(1500, (ActionListener) new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            etat.getJardin().retireCase(lapinPosition);
                            etat.getJardin().setCase(nextPosition, lapin);
                            lapin.setPosition(nextPosition);
                            path.remove(path.size() - 1);
                        }

                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            }
            int x = lapin.getPosition().x;
            int y = lapin.getPosition().y;

        }
    }
    public void deplacementJardinier(Jardinier j){

        ArrayList<AStar.Node> a = aStar.arrayList;
        if(a.size() > 1){
            etat.getJardin().retireCase(j.getPosition());
            etat.getJardin().setCase(new Point(a.get(a.size()-2).getY(), a.get(a.size()-2).getX()), j);
            j.setPosition(new Point(a.get(a.size()-2).getY(), a.get(a.size()-2).getX()));
            a.remove(a.size()-1);
        }
    }

    /**
     * Dessine tous les fleurs
     * @param g
     */

    public void dessineFleurs(Graphics g){
        ArrayList<Fleur> fleurs = etat.getFleurs();
        for(int i = 0 ; i < fleurs.size(); i++){
            Fleur f = fleurs.get(i);
            int x = f.getPosition().x;
            int y = f.getPosition().y;
            int taille_case_x = getWidth() / etat.getLargeurJardin();
            int taille_case_y = getHeight() / etat.getHauteurJardin();
            //g.setColor(fleurs.get(i).getCouleur());
            Fleur.Type type = f.getType();

            URL url1 = getClass().getResource("/resources/Fleur/"+type+1+".png");
            ImageIcon userIcon1 = new ImageIcon(url1);
            Image image1 = userIcon1.getImage();
            URL url2 = getClass().getResource("/resources/Fleur/"+type+2+".png");
            ImageIcon userIcon2 = new ImageIcon(url2);
            Image image2 = userIcon2.getImage();
            URL url3 = getClass().getResource("/resources/Fleur/"+type+3+".png");
            ImageIcon userIcon3 = new ImageIcon(url3);
            Image image3 = userIcon3.getImage();
            URL url = getClass().getResource("/resources/Fleur/"+type+4+".png");
            ImageIcon userIcon = new ImageIcon(url);
            Image image = userIcon.getImage();

            // Changement des images en fonction de la couleur du fleur
            if(f.getType() == type){
                if(f.getCouleur() == Color.green){
                    g.drawImage(image1,x*taille_case_x,y*taille_case_y,taille_case_x,taille_case_x,null);
                }else if(f.getCouleur() == Color.yellow){
                    g.drawImage(image2,x*taille_case_x,y*taille_case_y,taille_case_x,taille_case_x,null);
                }else if(f.getCouleur() == Color.orange){
                    g.drawImage(image3,x*taille_case_x,y*taille_case_y,taille_case_x,taille_case_x,null);
                }else if(f.getCouleur() == Color.red){
                    g.drawImage(image,x*taille_case_x,y*taille_case_y,taille_case_x,taille_case_x,null);
                }
            }
            //g.fillOval(x*taille_case_x+(taille_case_x/4),y*taille_case_y+(taille_case_y/4),taille_case_x/2,taille_case_y/2);
        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        dessineJardin(g);
        dessineBatiment(g);
        dessineJardinier(g);
        dessineFleurs(g);
        dessineLapin(g);
        dessinerouteLapin(g);
    }


    public int getLargeurCase(){return getWidth()/etat.getLargeurJardin();}


    public int getHauteurCase(){return getHeight()/etat.getHauteurJardin();}


    public void dessineTarget(Graphics g) {
        if(targetPosition != null) {
            int x = targetPosition.x;
            int y = targetPosition.y;
            int taille_case_x = getWidth() / etat.getLargeurJardin();
            int taille_case_y = getHeight() / etat.getHauteurJardin();
            g.setColor(Color.PINK);
            g.fillRect(x * taille_case_x, y * taille_case_y, taille_case_x, taille_case_y);
        }
    }

    public void dessineChemin(Graphics g, ArrayList<Node> chemin) {

        int taille_case_x = getWidth() / etat.getLargeurJardin();
        int taille_case_y = getHeight() / etat.getHauteurJardin();
        for (Node node : chemin) {
            g.setColor(Color.GREEN);
            g.fillRect(node.y * taille_case_x, node.x * taille_case_y, taille_case_x, taille_case_y);
        }
    }

    public void setTargetPosition(Point p){this.targetPosition = p;}

    public void dessineLapin(Graphics g) {
        ArrayList<Lapin> Lapins = etat.getLapins();
        int nbLapins = Lapins.size();

        URL url4 = getClass().getResource("/resources/lapin.png");
        ImageIcon userIcon4 = new ImageIcon(url4);
        Image image4 = userIcon4.getImage();

        for(int i=0;i<nbLapins;i++){
            Lapin lapin = Lapins.get(i);
            int x = Lapins.get(i).getPosition().x;
            int y = Lapins.get(i).getPosition().y;
            int taille_case_x = getWidth() / etat.getLargeurJardin();
            int taille_case_y = getHeight() / etat.getHauteurJardin();
            g.setColor(Color.PINK);
            g.drawImage(image4,x*taille_case_x,y*taille_case_y,taille_case_x,taille_case_x,null);
            //g.fillOval(x*taille_case_x + (taille_case_x/4), y*taille_case_y + (taille_case_y/4), taille_case_x/2, taille_case_y/2);
        }
    }
}
