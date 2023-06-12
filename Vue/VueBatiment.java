package Vue;

import Controle.*;
import Modele.Etat;

import java.awt.*;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class VueBatiment extends JPanel {
    private Etat etat;
    private VueJardin vueJardin;
    private Controlleur controlleur;
    private static JButton acheterGraines;
    private static JButton produireBouquet;
    private static JButton vendreBouquet;
    private static JButton recruterJardinier;
    static JButton ChoisirRose = new JButton("Rose");
    static JButton ChoisirLys = new JButton("Lys");
    static JButton ChoisirTulipe = new JButton("Tulipe");
    static JButton ChoisirMixte = new JButton("Mixtes");


    public VueBatiment(Etat etat, VueJardin vueJardin, Affichage a) {
        this.etat = etat;
        this.vueJardin = vueJardin;
        controlleur = new Controlleur(etat,vueJardin, a);
        //setPreferredSize(new Dimension(300, 800));
        setBackground(new Color(230, 235, 250));
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weighty = 1;

        constraints.anchor = GridBagConstraints.NORTH;
        // User Icon
        URL url = getClass().getResource("/resources/user-icon.png");
        ImageIcon userIcon = new ImageIcon(url);
        Image image = userIcon.getImage();
        Image newImage = image.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
        userIcon = new ImageIcon(newImage);
        JLabel label = new JLabel(userIcon);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.insets = new Insets(20, 20, 20, 20);
        add(label, constraints);


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
        add(ChoisirRose, constraints);

        ChoisirRose ChoisirRoseCon = new ChoisirRose(etat, vueJardin);
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
        add(ChoisirLys, constraints);

        ChoisirLys choisirLysCon = new ChoisirLys(etat, vueJardin);
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
        add(ChoisirTulipe, constraints);

        ChoisirTulipe choisirTulipeCon = new ChoisirTulipe(etat, vueJardin);
        ChoisirTulipe.addMouseListener(choisirTulipeCon);

        // Mixtes Button

        ChoisirMixte.setOpaque(true);
        ChoisirMixte.setPreferredSize(new Dimension(50, 30));
        ChoisirMixte.setBackground(Color.ORANGE);
        ChoisirMixte.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        constraints.gridx = 3;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 3;
        constraints.insets = new Insets(0, 5, 0, 5);
        add(ChoisirMixte, constraints);
        ChoisirMixte choisir_Mixte = new ChoisirMixte(etat, vueJardin);
        ChoisirMixte.addMouseListener(choisir_Mixte);


        JButton acheterGraines = new JButton("Acheter Graines");
        acheterGraines.setOpaque(true);
        acheterGraines.setPreferredSize(new Dimension(200, 45));
        acheterGraines.setBackground(Color.PINK);
        acheterGraines.setForeground(Color.DARK_GRAY);
        acheterGraines.setFont(new Font("Arial", Font.BOLD, 18));
        acheterGraines.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        acheterGraines.setActionCommand("Acheter Graines");
        acheterGraines.addActionListener(controlleur);
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.insets = new Insets(10, 10, 10, 10);
        add(acheterGraines, constraints);
        this.acheterGraines = acheterGraines;

        JButton produireBouquet = new JButton("Produire Bouquet");
        produireBouquet.setOpaque(true);
        produireBouquet.setPreferredSize(new Dimension(200, 45));
        produireBouquet.setBackground(Color.CYAN);
        produireBouquet.setForeground(Color.DARK_GRAY);
        produireBouquet.setFont(new Font("Arial", Font.BOLD, 18));
        produireBouquet.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        produireBouquet.setActionCommand("Produire Bouquet");
        produireBouquet.addActionListener(controlleur);
        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.insets = new Insets(10, 10, 10, 10);
        add(produireBouquet, constraints);
        this.produireBouquet = produireBouquet;

        JButton vendreBouquet = new JButton("Vendre Bouquet");
        vendreBouquet.setOpaque(true);
        vendreBouquet.setPreferredSize(new Dimension(200, 45));
        vendreBouquet.setBackground(Color.YELLOW);
        vendreBouquet.setForeground(Color.DARK_GRAY);
        vendreBouquet.setFont(new Font("Arial", Font.BOLD, 18));
        vendreBouquet.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        vendreBouquet.setActionCommand("Vendre Bouquet");
        vendreBouquet.addActionListener(controlleur);
        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.insets = new Insets(10, 10, 10, 10);
        add(vendreBouquet,constraints);
        this.vendreBouquet = vendreBouquet;

        JButton recruterJardinier = new JButton("Recruter jardinier");
        recruterJardinier.setOpaque(true);
        recruterJardinier.setPreferredSize(new Dimension(200, 45));
        recruterJardinier.setBackground(Color.lightGray);
        recruterJardinier.setForeground(Color.DARK_GRAY);
        recruterJardinier.setFont(new Font("Arial", Font.BOLD, 18));
        recruterJardinier.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        recruterJardinier.setActionCommand("Recruter jardiner");
        recruterJardinier.addActionListener(controlleur);
        constraints.gridx = 0;
        constraints.gridy = 9;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.insets = new Insets(10, 10, 10, 10);
        add(recruterJardinier, constraints);
        this.recruterJardinier = recruterJardinier;





        addButton("Rose", Color.RED, new ChoisirRose(etat, vueJardin));
        addButton("Lys", Color.GREEN, new ChoisirLys(etat, vueJardin));
        addButton("Tulipe", Color.cyan, new ChoisirTulipe(etat, vueJardin));
        addButton("Mixtes", Color.ORANGE, new ChoisirMixte(etat, vueJardin));


        /*JButton planterFleur = new JButton("Planter Fleur");
        planterFleur.setOpaque(true);
        planterFleur.setPreferredSize(new Dimension(200, 60));
        planterFleur.setBackground(Color.orange);
        planterFleur.setForeground(Color.DARK_GRAY);
        planterFleur.setFont(new Font("Arial", Font.BOLD, 18));
        planterFleur.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        planterFleur.setActionCommand("Planter Fleur");
        planterFleur.addActionListener(controlleur);
        constraints.gridx = 0;
        constraints.gridy = 9;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.insets = new Insets(10, 10, 10, 10);
        add(planterFleur,constraints);
        this.planterFleur = planterFleur;

        JButton RecolterFleur = new JButton("Recolter Fleur");
        RecolterFleur.setOpaque(true);
        RecolterFleur.setPreferredSize(new Dimension(200, 60));
        RecolterFleur.setBackground(Color.MAGENTA);
        RecolterFleur.setForeground(Color.DARK_GRAY);
        RecolterFleur.setFont(new Font("Arial", Font.BOLD, 18));
        RecolterFleur.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        RecolterFleur.setActionCommand("Recolter Fleur");
        RecolterFleur.addActionListener(controlleur);
        constraints.gridx = 0;
        constraints.gridy = 10;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.insets = new Insets(10, 10, 10, 10);
        add(RecolterFleur,constraints);
        this.RecolterFleur = RecolterFleur;
        */


        //label.setHorizontalAlignment(JLabel.CENTER);
       // label.setVerticalAlignment(JLabel.TOP);


    }
    public void addButton( String name, Color color, MouseListener listener) {
        JButton button = new JButton(name);
        button.setOpaque(true);
        button.setPreferredSize(new Dimension(50, 50));
        button.setBackground(color);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        button.addMouseListener(listener);
    }

    public static void addAcheterGrainesListener(AcheterGraines listener) {
        /**
       for(MouseListener m : acheterGraines.getMouseListeners()){
           acheterGraines.removeMouseListener(m);
        }*/
        acheterGraines.addMouseListener(listener);
    }
    public static void addProduireBouquetListener(ProduireBouquet listener) {
        produireBouquet.addMouseListener(listener);
    }
    public static void addVendreBouquetListener(VendreBouquet listener) {
        vendreBouquet.addMouseListener(listener);
    }

    public static void removeAllListenersBat() {
        for (MouseListener m : acheterGraines.getMouseListeners()) {
            acheterGraines.removeMouseListener(m);
        }
        for (MouseListener listener : produireBouquet.getMouseListeners()) {
            produireBouquet.removeMouseListener(listener);
        }
        for (MouseListener listener : vendreBouquet.getMouseListeners()) {
            vendreBouquet.removeMouseListener(listener);
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

    }




}