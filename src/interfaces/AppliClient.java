package interfaces;

import interfaces.vue.Jeu;
import interfaces.vue.Menu;
import interfaces.vue.Settings;

import javax.swing.*;
import java.awt.event.*;

public class AppliClient {
    public static void main(String[] args) {
        Menu fenetre1 = new Menu("BattleShip BeeYard Edition");
        Jeu fenetref = new Jeu("Partie de bataille navale - BeeYard en cours");
        Settings essai = new Settings("Settings");



        fenetre1.pack();
        fenetre1.setVisible(true);
        fenetref.pack();
        fenetref.setVisible(true);
        essai.pack();
        essai.setVisible(true);
    }
}
