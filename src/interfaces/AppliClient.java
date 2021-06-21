package interfaces;

import interfaces.vue.menu;

import javax.swing.*;

public class AppliClient {
    public static void main(String[] args) {
        menu fenetre1 = new menu("BattleShip BeeYard Edition");




        fenetre1.pack();
        fenetre1.setVisible(true);
    }
}
