package interfaces;

import interfaces.vue.Menu;
import interfaces.vue.Settings;

public class AppliClient {
    public static void main(String[] args) {
        Menu fenetre1 = new Menu("BattleShip BeeYard Edition");
        Settings essai = new Settings("Settings");



        fenetre1.pack();
        fenetre1.setVisible(true);
        essai.pack();
        essai.setVisible(true);
    }
}
