package Modele.Unite;

import java.awt.*;

public class Unite {
    protected Point position;

    public Unite(Point p){
        position = p;
    }
    
    public Point getPosition(){
        return position;
    }

    public void setPosition(Point p){
        position = p;
    }

    

}