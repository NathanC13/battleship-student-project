package interfaces.controleurs.menu;

import info1.network.Network;
import interfaces.vue.MenuPrincipal;
import interfaces.vue.PositionnementBateau;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameControleur implements ActionListener {

    private MenuPrincipal fenetre;
    private PositionnementBateau fenetreBateau;

    public NewGameControleur(MenuPrincipal fenetre, PositionnementBateau fenetreBateau){
        this.fenetre = fenetre;
        this.fenetreBateau = fenetreBateau;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        this.fenetreBateau.setVisible(true);
        this.fenetre.dispose();

        if (fenetre.getBe().isSelected()){
            fenetreBateau.getBateau5().setEnabled(false);
            System.out.println("yes");
        }else if (fenetre.getFr().isSelected()){
            fenetreBateau.getBateau1().setEnabled(false);
            System.out.println("non");
        }

    }
}
