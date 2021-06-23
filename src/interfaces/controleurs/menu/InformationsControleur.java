package interfaces.controleurs.menu;

import interfaces.vue.Menu;
import interfaces.vue.PositionnementBateau;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class    InformationsControleur implements ActionListener {

    private Menu fenetre;
    private PositionnementBateau fenetreBateau;

    public InformationsControleur(Menu fenetre){
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = new JFrame("showMessageDialog");
        String message = "Le jeu BattleShip Beeyard ";
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(frame, message, "Informations", JOptionPane.INFORMATION_MESSAGE);

    }
}
