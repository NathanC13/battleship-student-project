package interfaces.controleurs.menu;

import interfaces.vue.MenuPrincipal;
import interfaces.vue.PositionnementBateau;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class   BelgeControleur implements ActionListener {

    private MenuPrincipal fenetre;
    private PositionnementBateau fenetreBateau;

    public BelgeControleur(MenuPrincipal fenetre){
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("Passage du jeu en version belge.");

    }
}
