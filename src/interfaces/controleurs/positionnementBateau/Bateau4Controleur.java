package interfaces.controleurs.positionnementBateau;

import interfaces.vue.PositionnementBateau;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bateau4Controleur implements ActionListener {

    private PositionnementBateau fenetre;

    public Bateau4Controleur(PositionnementBateau fenetre){
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fenetre.setBateauSelected(true,3);
        fenetre.getBateau4().setEnabled(false);
    }
}
