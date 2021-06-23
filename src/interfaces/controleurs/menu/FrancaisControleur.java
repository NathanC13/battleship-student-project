package interfaces.controleurs.menu;

import interfaces.vue.MenuPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class    FrancaisControleur implements ActionListener {

    private MenuPrincipal fenetre;

    public FrancaisControleur(MenuPrincipal fenetre) {
        this.fenetre = fenetre;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("nique ta mère");


    }
}