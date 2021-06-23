package interfaces.controleurs.positionnementBateau;

import info1.network.Network;
import interfaces.vue.Plateau;
import interfaces.vue.PositionnementBateau;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayGameControleur implements ActionListener {

    private PositionnementBateau positionnementBateau;
    private Plateau plateau;

    public PlayGameControleur(PositionnementBateau positionnementBateau, Plateau plateau){
        this.positionnementBateau = positionnementBateau;
        this.plateau = plateau;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        this.plateau.setVisible(true);
        this.positionnementBateau.dispose();
    }
}
