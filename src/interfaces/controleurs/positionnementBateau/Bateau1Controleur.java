package interfaces.controleurs.positionnementBateau;

import interfaces.vue.PositionnementBateau;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bateau1Controleur implements ActionListener {

    private PositionnementBateau fenetre;

    public Bateau1Controleur(PositionnementBateau fenetre){
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fenetre.setBateauSelected(true,0);
        fenetre.getBateau1().setEnabled(false);

    }
}
