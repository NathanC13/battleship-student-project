package interfaces.controleurs.plateaudejeu;

import interfaces.vue.Plateau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Help2 implements ActionListener {
    private Plateau plateau;
    
    public Help2(){
        this.plateau = plateau;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = new JFrame("Informations de jeu");
        String message = "Le bouton Settings vous permet d'accéder aux paramètres du jeu.\n\nLa zone située à gauche représente votre flotte et la zone à droite, la flotte ennemie\n\nVous jouez chacun votre tour, en sélectionnant une case située dans la flotte ennemie\n\nLe jeu s'arrête lorsque l'un des deux joueurs n'a plus de bateaux dans sa flotte";
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(frame, message, "Help", JOptionPane.INFORMATION_MESSAGE);
    }
}
