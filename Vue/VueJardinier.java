package Vue;
import Controle.*;
import Modele.*;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Modele.Unite.*;
import Modele.Unite.Fleur.Type;;

public class VueJardinier{
    private VueJardin vueJardin;
    Etat etat;
    Jardinier jardinier;
    JPanel interfaceJardinier;
    static JButton planterFleur = new JButton("Planter");
    static JButton recolterFleur = new JButton("Récolter");
    static JButton ChoisirRose = new JButton("Rose");
    static JButton ChoisirLys = new JButton("Lys");
    static JButton ChoisirTulipe = new JButton("Tulipe");
    static JButton chasserLapin = new JButton("Chasser");



    public VueJardinier(Etat e, Jardinier j, Controlleur control, VueJardin vueJardin){
        this.jardinier = j;
        this.etat = e;

        this.vueJardin = vueJardin;
        this.interfaceJardinier = new JPanel();
        interfaceJardinier.setLayout(new BoxLayout(interfaceJardinier, BoxLayout.PAGE_AXIS));
        ImageIcon imageIcon = new ImageIcon("resources/jardinier.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);
        interfaceJardinier.add(new JLabel(imageIcon));
        GridBagConstraints constraints = new GridBagConstraints();



        // Rose Button

        ChoisirRose.setOpaque(true);
        ChoisirRose.setPreferredSize(new Dimension(50, 50));
        ChoisirRose.setBackground(Color.RED);
        ChoisirRose.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 3;
        constraints.insets = new Insets(0, 5, 0, 5);
        this.interfaceJardinier.add(ChoisirRose, constraints);

        Controle.ChoisirRose ChoisirRoseCon = new ChoisirRose(etat, vueJardin);
        ChoisirRose.addMouseListener(ChoisirRoseCon);


        // Lys  Button

        ChoisirLys.setOpaque(true);
        ChoisirLys.setPreferredSize(new Dimension(50, 50));
        ChoisirLys.setBackground(Color.GREEN);
        ChoisirLys.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 3;
        constraints.insets = new Insets(0, 5, 0, 5);
        this.interfaceJardinier.add(ChoisirLys, constraints);


        Controle.ChoisirLys choisirLysCon = new ChoisirLys(etat, vueJardin);
        ChoisirLys.addMouseListener(choisirLysCon);


        // Tulipe Button

        ChoisirTulipe.setOpaque(true);
        ChoisirTulipe.setPreferredSize(new Dimension(50, 50));
        ChoisirTulipe.setBackground(Color.cyan);
        ChoisirTulipe.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 3;
        constraints.insets = new Insets(0, 5, 0, 5);
        this.interfaceJardinier.add(ChoisirTulipe, constraints);

        ChoisirTulipe choisirTulipeCon = new ChoisirTulipe(etat, vueJardin);
        ChoisirTulipe.addMouseListener(choisirTulipeCon);


        
        planterFleur.setOpaque(true);
        planterFleur.setPreferredSize(new Dimension(200, 60));
        planterFleur.setBackground(Color.orange);
        planterFleur.setForeground(Color.DARK_GRAY);
        planterFleur.setFont(new Font("Arial", Font.BOLD, 18));
        planterFleur.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        planterFleur.setActionCommand("Planter Fleur");
        planterFleur.addActionListener(control);
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.insets = new Insets(10, 10, 10, 10);
        

        
        recolterFleur.setOpaque(true);
        recolterFleur.setPreferredSize(new Dimension(200, 60));
        recolterFleur.setBackground(Color.MAGENTA);
        recolterFleur.setForeground(Color.DARK_GRAY);
        recolterFleur.setFont(new Font("Arial", Font.BOLD, 18));
        recolterFleur.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        recolterFleur.setActionCommand("Recolter Fleur");
        recolterFleur.addActionListener(control);
        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.insets = new Insets(10, 10, 10, 10);


        JButton chasserLapin = new JButton("Chasser lapin");
        chasserLapin.setOpaque(true);
        chasserLapin.setPreferredSize(new Dimension(200, 60));
        chasserLapin.setBackground(Color.PINK);
        chasserLapin.setForeground(Color.DARK_GRAY);
        chasserLapin.setFont(new Font("Arial", Font.BOLD, 18));
        chasserLapin.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        chasserLapin.setActionCommand("Chasser lapin");
        chasserLapin.addActionListener(control);
        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.insets = new Insets(10, 10, 10, 10);

        this.chasserLapin =  chasserLapin;




        JPanel buttons = new JPanel();
        //buttons.setLayout(new GridBagLayout());
        buttons.add(ChoisirRose,constraints);
        buttons.add(ChoisirLys,constraints);
        buttons.add(ChoisirTulipe,constraints);
        buttons.add(planterFleur, constraints);
        buttons.add(recolterFleur, constraints);

        buttons.add(chasserLapin,constraints);
        interfaceJardinier.add(buttons);



    }



    public JPanel getInterfaceJardinier(){
        return this.interfaceJardinier;
    }
    public static void addPlanterFleurListener(PlanterFleur listener) {
        planterFleur.addMouseListener(listener);
    }
    public static void addRecolterFleurListener(RecolterFleur listener) {
        recolterFleur.addMouseListener(listener);
    }

    public static void removeAllFleurListeners() {
        for (MouseListener listener : planterFleur.getMouseListeners()) {
            planterFleur.removeMouseListener(listener);
        }
        for (MouseListener listener : recolterFleur.getMouseListeners()) {
            recolterFleur.removeMouseListener(listener);
        }

        MouseListener[] listenerLys = ChoisirLys.getMouseListeners();
        if (listenerLys.length > 1){
            ChoisirRose.removeMouseListener(listenerLys[0]);
        }
        MouseListener[] listenersRose = ChoisirRose.getMouseListeners();
        if (listenersRose.length > 1){
            ChoisirRose.removeMouseListener(listenersRose[0]);
        }
        MouseListener[] listenersTulipe = ChoisirTulipe.getMouseListeners();
        if (listenersTulipe.length > 1){
            ChoisirRose.removeMouseListener(listenersTulipe[0]);
        }

        /**
        for (MouseListener listener : ChoisirRose.getMouseListeners()) {
            ChoisirRose.removeMouseListener(listener);
        }
        for (MouseListener listener : ChoisirLys.getMouseListeners()) {
            ChoisirLys.removeMouseListener(listener);
        }
        for (MouseListener listener : ChoisirTulipe.getMouseListeners()) {
            ChoisirTulipe.removeMouseListener(listener);
        }*/


    }

}