package interfaces.controleurs.creationServeur;

import com.mashape.unirest.http.exceptions.UnirestException;
import info1.network.Game;
import info1.network.Network;
import info1.network.Player;
import info1.ships.BadCoordException;
import info1.ships.ICoord;
import info1.ships.IShip;
import info1.ships.UncompleteFleetException;
import interfaces.Joueur;
import interfaces.controleurs.positionnementBateau.PlayGameControleur;
import interfaces.vue.CreationServeur;
import interfaces.vue.Plateau;
import interfaces.vue.PlateauImageComponent;
import interfaces.vue.PositionnementBateau;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class CreationServeurControleur implements ActionListener {

    private CreationServeur creationServeur;
    private Plateau plateau;
    private PositionnementBateau positionnementBateau;
    private Joueur joueur;
    private PlayGameControleur playGameControleur;

    public CreationServeurControleur(CreationServeur creationServeur, Plateau plateau, PositionnementBateau positionnementBateau, PlayGameControleur playGameControleur){

        this.creationServeur = creationServeur;
        this.plateau = plateau;
        this.positionnementBateau = positionnementBateau;
        this.joueur = positionnementBateau.getJoueur();
        this.playGameControleur = playGameControleur;

    }

    @Override
    public void actionPerformed(ActionEvent e) {


        try {
            System.out.println("FLOTTE" + joueur.getFlotte());
            System.out.println("PLAYER: " + playGameControleur.getP().getName());

            Game game = Network.initNewGame("http://37.187.38.219/api/v0", playGameControleur.getP(), joueur.getFlotte());
            System.out.println("ID: " + game.getId());
        } catch (UnirestException | UncompleteFleetException | BadCoordException unirestException) {
            unirestException.printStackTrace();
        }




        PlateauImageComponent[][] list = plateau.getCaselist();


        List<IShip> listBateau = joueur.getFlotte().getShips();

        System.out.println(listBateau.size());

        if (listBateau.size()>0) {
            List<ICoord> listCoord = listBateau.get(0).getCoords();
            System.out.println("test");
            for (int i = 1; i < listBateau.size(); i++) {
                listCoord.addAll(listBateau.get(i).getCoords());
            }

            for (int x = 0; x<10; x++){
                for (int y = 0; y<10; y++){
                    for (int bateau = 0; bateau<listCoord.size(); bateau++)
                        try {
                            Image img = ImageIO.read(new File("./img/cases_brouillon/case_bateau.png"));
                            if ((list[x][y].getId()[0]+1 == listCoord.get(bateau).getX()) && (list[x][y].getId()[1]+1 == listCoord.get(bateau).getY())){
                                list[y][x].setImg(img);
                            }
                        } catch (IOException exception) {
                            exception.printStackTrace();
                        }
                }
            }

        }

        plateau.invalidate(); //actualise la fenetre
        plateau.validate();
        plateau.repaint();






        plateau.setVisible(true);
        creationServeur.dispose();

    }

    public Joueur getJoueur() {
        return joueur;
    }
}
