package Modele.Unite;

import Modele.Etat;

import java.awt.*;

public class Lapin extends Unite {
    public Lapin(Etat e, Point position) {
        super(position);
        e.getJardin().setCase(position, this);
    }
}
