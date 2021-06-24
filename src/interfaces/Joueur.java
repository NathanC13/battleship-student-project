package interfaces;

import info1.ships.NavyFleet;
import info1.ships.Ship;

public class Joueur {

    private NavyFleet flotte;
    private String pseudo;


    public Joueur(){
        this.flotte = new NavyFleet();
    }

    public NavyFleet getFlotte() {
        return this.flotte;
    }

    public void addFlotte(Ship ship){
        this.flotte.add(ship);
    }

    public void clearFlotte(){
        this.flotte = new NavyFleet();
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
}
