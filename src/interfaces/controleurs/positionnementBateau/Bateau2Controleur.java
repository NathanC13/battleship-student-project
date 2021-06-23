package interfaces.controleurs.positionnementBateau;

import interfaces.vue.PositionnementBateau;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bateau2Controleur implements ActionListener {

    private PositionnementBateau fenetre;

    public Bateau2Controleur(PositionnementBateau fenetre){
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fenetre.setBateauSelected(true,1);
        fenetre.getBateau2().setEnabled(false);
    }
}
