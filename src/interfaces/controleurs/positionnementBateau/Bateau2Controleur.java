package interfaces.controleurs.positionnementBateau;

import info1.ships.ShipCategory;
import interfaces.Joueur;
import interfaces.vue.PositionnementBateau;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bateau2Controleur implements ActionListener {

    private PositionnementBateau fenetre;
    private Joueur joueur;

    public Bateau2Controleur(PositionnementBateau fenetre,Joueur joueur){
        this.fenetre = fenetre;
        this.joueur = joueur;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //if (fenetre.getBateau2().isSelected()) {
        for(int i =0; i< 5;i++ ) {
            System.out.println("debut" + fenetre.getBateauSelected1()[i]);
        }


            fenetre.getBateau2().setEnabled(false);

        if(!fenetre.getBateau2().isSelected()){
            if(joueur.getFlotte().getShips(ShipCategory.SUBMARINE).size()== 4){
                fenetre.setBateauSelected(false, 0);
                fenetre.getBateau1().setEnabled(false);
            }else{
                fenetre.getBateau1().setEnabled(true);
            }
            if(joueur.getFlotte().getShips(ShipCategory.CRUISER).size()== 2){
                fenetre.setBateauSelected(false, 2);
                fenetre.getBateau3().setEnabled(false);
            }else{
                fenetre.getBateau3().setEnabled(true);
            }
            if(joueur.getFlotte().getShips(ShipCategory.BATTLESHIP).size()== 1){
                fenetre.setBateauSelected(false, 3);
                fenetre.getBateau4().setEnabled(false);
            }else{
                fenetre.getBateau4().setEnabled(true);
            }

        }
        fenetre.setBateauSelected(true, 1);
        for(int j =0; j< 5;j++ ) {
            System.out.println("fin" + fenetre.getBateauSelected1()[j]);
        }
    }
    }

