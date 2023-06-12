package Modele;

public class Message extends Thread{
    private Etat etat;
    private String message;
    private int temps;
    //private VueJardin affichage;

    public Message(String message, Etat etat){
        this.message=message;
        this.etat=etat;
        this.start();
        temps=50;
    }

    public String getMessage(){return message;}
    @Override
    public void run(){
        while(temps>=0) {
            if (temps == 0) {
                etat.setMessage(new Message(null, etat));
            }
            temps--;
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
