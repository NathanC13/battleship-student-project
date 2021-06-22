package interfaces;

import interfaces.vue.Jeu;
import interfaces.vue.Menu;

import javax.swing.*;
import java.awt.event.*;

public class AppliClient {
    public static void main(String[] args) {
        Menu fenetre1 = new Menu("BattleShip BeeYard Edition");
        Jeu fenetref = new Jeu("Partie de bataille navale - BeeYard en cours");




        fenetre1.pack();
        fenetre1.setVisible(true);
        fenetref.pack();
        fenetref.setVisible(true);
    }
}
