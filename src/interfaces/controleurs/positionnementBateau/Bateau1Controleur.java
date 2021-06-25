package interfaces.controleurs.positionnementBateau;

import info1.ships.ShipCategory;
import interfaces.vue.PositionnementBateau;
import interfaces.Joueur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bateau1Controleur implements ActionListener {

    private PositionnementBateau fenetre;
    private Joueur joueur;

    public Bateau1Controleur(PositionnementBateau fenetre, Joueur joueur) {
        this.fenetre = fenetre;
        this.joueur = joueur;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //if (fenetre.getBateau1().isSelected()) {
        for(int i =0; i< 5;i++ ) {
             System.out.println("debut" + fenetre.getBateauSelected1()[i]);
        }
            fenetre.getBateau1().setEnabled(false);


        if(!fenetre.getBateau1().isSelected()){
            if(joueur.getFlotte().getShips(ShipCategory.DESTROYER).size()== 3){
                System.out.println("test");
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
            if(joueur.getFlotte().getShips(ShipCategory.BATTLESHIP).size()== 1){
                fenetre.setBateauSelected(false, 3);
                fenetre.getBateau4().setEnabled(false);
            }else{
                fenetre.getBateau4().setEnabled(true);
            }


        }
        fenetre.setBateauSelected(true, 0);
        for(int j =0; j< 5;j++ ) {
            System.out.println("debut" + fenetre.getBateauSelected1()[j]);
        }
    }


}