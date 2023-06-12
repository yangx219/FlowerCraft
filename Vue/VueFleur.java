package Vue;
import Modele.*;
import Controle.Controlleur;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

import Modele.Unite.*;;
public class VueFleur implements Runnable{
    Fleur fleur;
    JPanel interfaceFleur;
    int duree;
    JLabel  time;
    Etat etat;


    public VueFleur(Etat etat, Fleur fleur, Controlleur control) {
        this.fleur = fleur;

        this.interfaceFleur = new JPanel();
        interfaceFleur.setLayout(new BoxLayout(interfaceFleur, BoxLayout.PAGE_AXIS));
        ImageIcon imageIcon = new ImageIcon("resources/Fleur/"+fleur.getType() +"4.png"); // load the image to a imageIcon
        System.out.println(this.fleur.getType());
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);
        interfaceFleur.add(new JLabel(imageIcon));
        GridBagConstraints constraints = new GridBagConstraints();

        JLabel  typeFleur = new JLabel("Flower Type: " + this.fleur.getType());
        //JLabel  time  = new JLabel("Time: " + this.fleur.getDuree() + " seconds");
        duree = this.fleur.getDuree();
        time  = new JLabel("Time: " + duree + " seconds");




        typeFleur.setOpaque(true);
        typeFleur.setPreferredSize(new Dimension(200, 60));
        typeFleur.setBackground(Color.orange);
        typeFleur.setForeground(Color.DARK_GRAY);
        typeFleur.setFont(new Font("Arial", Font.BOLD, 18));
        typeFleur.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        constraints.gridx = 0;
        constraints.gridy = 9;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.insets = new Insets(10, 10, 10, 10);



        time.setOpaque(true);
        time.setPreferredSize(new Dimension(200, 60));
        time.setBackground(Color.MAGENTA);
        time.setForeground(Color.DARK_GRAY);
        time.setFont(new Font("Arial", Font.BOLD, 18));
        time.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        constraints.gridx = 0;
        constraints.gridy = 10;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.insets = new Insets(10, 10, 10, 10);


        JPanel Label = new JPanel();
        //buttons.setLayout(new GridBagLayout());
        Label.add(typeFleur, constraints);
        Label.add(time, constraints);

        interfaceFleur.add(Label);
    }


    public JPanel getInterfaceFleur(){
        return this.interfaceFleur;
    }


    /**
     * Runs this operation.
     */
    @Override
    public void run() {

            while(true){
                this.interfaceFleur.repaint();
                this.interfaceFleur.revalidate();
                try {
                    Thread.sleep(100);}
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
    }
}
