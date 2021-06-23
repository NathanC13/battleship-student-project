package interfaces.controleurs.menu;

import interfaces.vue.MenuPrincipal;
import interfaces.vue.PositionnementBateau;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class    InformationsControleur implements ActionListener {

    private MenuPrincipal fenetre;
    private PositionnementBateau fenetreBateau;

    public InformationsControleur(MenuPrincipal fenetre){
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = new JFrame("Informations de jeu");
        String message = " Informations sur les règles du jeu : \n    - Afin de connaître les règles du jeu, rendez-vous sur la page wikipedia en utilisant le lien suivant : \n         https://fr.wikipedia.org/wiki/Bataille_navale_(jeu) \n\n Informations sur le style de jeu : \n    - Vous pouvez choisir entre deux modes de jeu différents, en choisissant soit la version Française soit la version Belge\n      en utilisant les boutons situés en bas à droite. \n\n Informations sur le fonctionnement du jeu :\n    - Après avoir choisis votre mode de jeu, vous pouvez cliquer sur Nouvelle Partie, qui vous lancera une nouvelle partie \n      contre un autre joueur en utilisant le serveur de l'IUT de Nantes. En cliquant sur Quitter, vous quitterez le jeu.";
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(frame, message, "Informations", JOptionPane.INFORMATION_MESSAGE);

    }
}
