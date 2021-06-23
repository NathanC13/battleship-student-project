package interfaces.controleurs.positionnementBateau;

import interfaces.vue.PositionnementBateau;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bateau5Controleur implements ActionListener {

    private PositionnementBateau fenetre;

    public Bateau5Controleur(PositionnementBateau fenetre){
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fenetre.setBateauSelected(true,4);
        fenetre.getBateau5().setEnabled(false);
    }
}
