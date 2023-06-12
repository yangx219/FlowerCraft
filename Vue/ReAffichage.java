package Vue;

public class ReAffichage extends Thread {

    VueJardin affichage;
    

    public ReAffichage(VueJardin a){
        affichage = a;
    }

    @Override
    public void run(){
        while(true){
            affichage.revalidate();
            affichage.repaint();
        try {Thread.sleep(150);}
        catch(Exception e){
            e.printStackTrace();
        }

    }
}

}
