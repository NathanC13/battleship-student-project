package interfaces.controleurs.positionnementBateau;

import info1.ships.ShipCategory;
import interfaces.Joueur;
import interfaces.vue.PositionnementBateau;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bateau4Controleur implements ActionListener {

    private PositionnementBateau fenetre;
    private Joueur joueur;

    public Bateau4Controleur(PositionnementBateau fenetre, Joueur joueur){
        this.fenetre = fenetre;
        this.joueur = joueur;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       // if (fenetre.getBateau4().isSelected()) {


            fenetre.getBateau4().setEnabled(false);

        if(!fenetre.getBateau4().isSelected()){
            System.out.println("test");
            if(joueur.getFlotte().getShips(ShipCategory.SUBMARINE).size()== 4){
                fenetre.setBateauSelected(false, 0);
                fenetre.getBateau1().setEnabled(false);
            }else{
                fenetre.getBateau1().setEnabled(true);
            }
            if(joueur.getFlotte().getShips(ShipCategory.DESTROYER).size()== 3){
                fenetre.setBateauSelected(false, 1);
                fenetre.getBateau2().setEnabled(false);
            }else{
                fenetre.getBateau2().setEnabled(true);
            }
            if(joueur.getFlotte().getShips(ShipCategory.CRUISER).size()== 2){
                fenetre.setBateauSelected(false, 2);
                fenetre.getBateau3().setEnabled(false);
            }else{
                fenetre.getBateau3().setEnabled(true);
            }


        }
        fenetre.setBateauSelected(true, 3);
    }
    }

