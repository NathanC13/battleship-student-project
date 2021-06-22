package interfaces;

import interfaces.vue.Menu;

import javax.swing.*;
import java.awt.event.*;

public class AppliClient {
    public static void main(String[] args) {
        Menu fenetre1 = new Menu("BattleShip BeeYard Edition");



        fenetre1.pack();
        fenetre1.setVisible(true);
    }
}
