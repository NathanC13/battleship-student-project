package interfaces.controleurs.positionnementBateau;

import info1.ships.ShipCategory;
import interfaces.Joueur;
import interfaces.vue.PositionnementBateau;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bateau3Controleur implements ActionListener {

    private PositionnementBateau fenetre;
    private Joueur joueur;

    public Bateau3Controleur(PositionnementBateau fenetre,Joueur joueur){
        this.fenetre = fenetre;
        this.joueur = joueur;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //if (fenetre.getBateau3().isSelected()) {


            fenetre.getBateau3().setEnabled(false);

        if(!fenetre.getBateau3().isSelected()){
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

            if(joueur.getFlotte().getShips(ShipCategory.BATTLESHIP).size()== 1){
                fenetre.setBateauSelected(false, 3);
                fenetre.getBateau4().setEnabled(false);
            }else{
                fenetre.getBateau4().setEnabled(true);
            }


        }
        fenetre.setBateauSelected(true, 2);
    }

}
