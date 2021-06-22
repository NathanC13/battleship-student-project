package interfaces.controleurs.menu;

import interfaces.vue.Menu;
import interfaces.vue.PositionnementBateau;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameControleur implements ActionListener {

    private Menu fenetre;
    private PositionnementBateau fenetreBateau;

    public NewGameControleur(Menu fenetre, PositionnementBateau fenetreBateau){
        this.fenetre = fenetre;
        this.fenetreBateau = fenetreBateau;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        this.fenetreBateau.setVisible(true);
        this.fenetre.dispose();

    }
}
