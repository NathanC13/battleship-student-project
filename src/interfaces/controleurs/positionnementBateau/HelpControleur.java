package interfaces.controleurs.positionnementBateau;

import interfaces.vue.PositionnementBateau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpControleur implements ActionListener {

    private Menu fenetre;
    private PositionnementBateau pos;

    public HelpControleur(){
        this.fenetre = fenetre;
        this.pos = pos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = new JFrame("Informations de jeu");
        String message = "Le bouton Settings vous permet d'accéder aux paramètres du jeu.\n\nLes boutons représentants les bateaux doivent être sélectionnées\npour pouvoir positionner les bateaux.\n\nLe bouton Clear vous permet d'effacer le placement de vos bateaux afin de recommencer.\n\nUne fois vos bateaux placés, vous pouvez cliquer sur le bouton CONTINUER qui vous permettra de lancer une partie sur le serveur.";
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(frame, message, "Help", JOptionPane.INFORMATION_MESSAGE);

    }
}
