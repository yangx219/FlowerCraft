package Vue;


import Modele.Etat;
import Modele.Message;
import Modele.Unite.Fleur.Type;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class VuePrincipal extends JPanel{
    private Etat etat;
    private int width = 300;
    private int height = 400;

    public VuePrincipal(Etat e){
        this.etat=e;
        setPreferredSize(new Dimension(width, height));
        setBackground(new Color(222,222,222));

    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        dessineBordure(g);
        dessineInformation(g);
        dessineMessage(g);
        repaint();
    }

    private void dessineBordure(Graphics g){
        g.drawLine(0,0,width,0);
        g.drawLine(0,0,0,height);
        g.drawLine(0,height,width,height);
        g.drawLine(width,0,width,height);
    }

    private void dessineInformation(Graphics g){
        g.setFont(g.getFont().deriveFont(25f));
        g.drawString("Information général",30,30);
        g.setFont(g.getFont().deriveFont(15f));
        g.drawString("argent : "+ etat.getArgent(),15,60);
        g.drawString("graines_Rose : "+etat.getNombreGraines(Type.ROSE),15,80);
        g.drawString("graines_Lys : "+etat.getNombreGraines(Type.LYS),15,100);
        g.drawString("graines_TULIPE : "+etat.getNombreGraines(Type.TULIPE),15,120);
        g.drawString("Rose : "+etat.getNombreFleursRecolter(Type.ROSE),15,140);
        g.drawString("Lys: "+etat.getNombreFleursRecolter(Type.LYS),15,160);
        g.drawString("Tulipe : "+etat.getNombreFleursRecolter(Type.TULIPE),15,180);
        g.drawString("bouquet : "+etat.getBouquets().size(),15,200);
    }

    private void dessineMessage(Graphics g){
        Message message = etat.getMessage();
        if(message!=null){
            String m = message.getMessage();
            if(m!=null) {
                //message.start();
                //g.setFont(g.getFont().deriveFont(30f));
                //g.setColor(Color.black);
                //int demiTaille = m.length() / 2 * 15;
                g.drawString(m,15,220);
            }
        }

    }





}
