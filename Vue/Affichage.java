package Vue;
import java.awt.*;

import javax.swing.*;
import javax.swing.JFrame;

import Modele.*;
import Controle.*;
import Modele.Unite.Fleur;
;

public class Affichage extends JSplitPane{

    Etat etat;
    // Fenetre principal du jeu qui contient Jardin et Interface (ControlPanel)
    private JFrame fenetre;

    // Partie du jardin à gauche
    private VueJardin jardin;
    // Partie du control à droite
    private JSplitPane interface_ = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

    //private JPanel controlPanel_courant = null;

    private VueBatiment vueBatiment;

    private VueJardinier vueJardinier;
    private VueFleur vueFleur;
    private VuePrincipal vuePrincipal;
    Controlleur control;



    private GridBagConstraints constraints = new GridBagConstraints();

    public Affichage(Etat etat){
        this.etat = etat;

        this.jardin = new VueJardin(etat);
        this.vueBatiment = new VueBatiment(etat, jardin, this);
        this.fenetre = new JFrame("FlowerCraft");
        this.control = new Controlleur(etat, jardin, this);
        this.vuePrincipal = new VuePrincipal(etat);
       
        fenetre.setLayout(new GridBagLayout());


        afficheJardin();
        afficheInformation();

        // interface_ ( à gauche )
        vueBatiment.setPreferredSize(new Dimension(300, etat.getHauteur()-300));
        interface_.setPreferredSize(new Dimension(300, etat.getHauteur()-300));
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.BOTH ;





        // partie de la vue du jardinier (l'une des parties d'interface à gauche)
        vueJardinier = new VueJardinier(etat, etat.getJardiniers().get(0), control,getVueJardin());
        vueJardinier.getInterfaceJardinier().setPreferredSize(new Dimension(300,etat.getHauteur()-300));

        fenetre.add(interface_, constraints);




        /**
         * À AJOUTER :
         * vueBatiment
         * vueFleur 
        */ 


        fenetre.pack();
        fenetre.revalidate();
        fenetre.repaint();
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setLocationRelativeTo(null);


        fenetre.addMouseListener(control);
        uniteInterface();
    }

    private void afficheJardin(){
        // partie du jardin ( à droite )
        jardin.setPreferredSize(new Dimension(etat.getLargeur(), etat.getHauteur()));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 2;
        constraints.weightx=0.6;
        constraints.weighty=1;
        constraints.fill = GridBagConstraints.BOTH;
        fenetre.add(jardin, constraints);
    }

    private void afficheInformation(){
        vuePrincipal.setPreferredSize(new Dimension(300,250));
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.BOTH;
        fenetre.add(vuePrincipal,constraints);
    }


    public VueJardin getVueJardin(){return jardin;}


    public void uniteInterface(){
        

        if(etat.getUnitesSelected().size()==0) {
            interface_.remove(vueJardinier.getInterfaceJardinier());
            if (vueFleur != null) {
                interface_.remove(vueFleur.getInterfaceFleur());
                vueFleur = null;
            }
            interface_.add(vueBatiment);
            //System.out.println("Affichage: controlPanel");
        }else if (etat.fleurPresent(etat.getCaseSelected())!=null&&(etat.fleurPresent(etat.getCaseSelected()).getType() == Fleur.Type.ROSE || etat.fleurPresent(etat.getCaseSelected()).getType() == Fleur.Type.TULIPE||etat.fleurPresent(etat.getCaseSelected()).getType() == Fleur.Type.LYS) && !etat.jardinierPresent(etat.getCaseSelected())){
            if (vueFleur != null) {
                interface_.remove(vueFleur.getInterfaceFleur());
            }
            this.vueFleur = new VueFleur(etat, etat.fleurPresent(etat.getCaseSelected()), control);
            vueFleur.getInterfaceFleur().setPreferredSize(new Dimension(300, etat.getHauteur() - 300));
            interface_.remove(vueBatiment);
            interface_.remove(vueJardinier.getInterfaceJardinier());
            interface_.add(vueFleur.getInterfaceFleur());
        }else{
            interface_.remove(vueBatiment);
            if (vueFleur != null) {
                interface_.remove(vueFleur.getInterfaceFleur());
                vueFleur = null;
            }
            interface_.add(vueJardinier.getInterfaceJardinier());
            //interface_.add(vueFleur.getInterfaceFleur());
            
            //interface_ = new JSplitPane(SwingConstants.HORIZONTAL, vueJardinier.getInterfaceJardinier(), vueFleur.getInterfaceFleur());
            
            //System.out.println("Affichage : vueJardinier");
        }


        

        
    }
}