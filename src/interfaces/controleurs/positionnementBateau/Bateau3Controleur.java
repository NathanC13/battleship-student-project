package interfaces.controleurs.positionnementBateau;

import interfaces.vue.PositionnementBateau;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bateau3Controleur implements ActionListener {

    private PositionnementBateau fenetre;

    public Bateau3Controleur(PositionnementBateau fenetre){
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fenetre.setBateauSelected(true,2);
        fenetre.getBateau3().setEnabled(false);
    }
}
