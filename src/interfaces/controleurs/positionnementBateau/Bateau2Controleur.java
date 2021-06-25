package interfaces.controleurs.positionnementBateau;

import info1.ships.ShipCategory;
import interfaces.Joueur;
import interfaces.vue.MenuPrincipal;
import interfaces.vue.PositionnementBateau;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bateau2Controleur implements ActionListener {

    private PositionnementBateau fenetre;
    private Joueur joueur;
    private MenuPrincipal menu;

    public Bateau2Controleur(PositionnementBateau fenetre,Joueur joueur, MenuPrincipal menu){
        this.fenetre = fenetre;
        this.joueur = joueur;
        this.menu = menu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Nous faisons en sorte de decliquer puis recliquer sur les boutons pour placer
        // Nous differencions belge et francais en limitant le nombre de bateau apr categorie
    if(menu.getBe().isSelected()) {
        fenetre.getBateau2().setEnabled(false);

        if (!fenetre.getBateau2().isSelected()) {
            if (joueur.getFlotte().getShips(ShipCategory.SUBMARINE).size() == 4) {
                fenetre.setBateauSelected(false, 0);
                fenetre.getBateau1().setEnabled(false);
            } else {
                fenetre.getBateau1().setEnabled(true);
            }
            if (joueur.getFlotte().getShips(ShipCategory.CRUISER).size() == 2) {
                fenetre.setBateauSelected(false, 2);
                fenetre.getBateau3().setEnabled(false);
            } else {
                fenetre.getBateau3().setEnabled(true);
            }
            if (joueur.getFlotte().getShips(ShipCategory.BATTLESHIP).size() == 1) {
                fenetre.setBateauSelected(false, 3);
                fenetre.getBateau4().setEnabled(false);
            } else {
                fenetre.getBateau4().setEnabled(true);
            }

        }
        fenetre.setBateauSelected(true, 1);
    }
    if(menu.getFr().isSelected()){
        fenetre.getBateau2().setEnabled(false);

        if (!fenetre.getBateau2().isSelected()) {
            if (joueur.getFlotte().getShips(ShipCategory.CRUISER).size() == 2) {
                fenetre.setBateauSelected(false, 2);
                fenetre.getBateau3().setEnabled(false);
            } else {
                fenetre.getBateau3().setEnabled(true);
            }
            if (joueur.getFlotte().getShips(ShipCategory.BATTLESHIP).size() == 1) {
                fenetre.setBateauSelected(false, 3);
                fenetre.getBateau4().setEnabled(false);
            } else {
                fenetre.getBateau4().setEnabled(true);
            }

        }
        fenetre.setBateauSelected(true, 1);

    }

    }
    }

