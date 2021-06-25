package interfaces.controleurs.ServeurChoix;



import com.mashape.unirest.http.exceptions.UnirestException;
import info1.network.Game;
import info1.network.Network;
import info1.network.Player;
import info1.ships.BadCoordException;
import info1.ships.ICoord;
import info1.ships.IShip;
import info1.ships.UncompleteFleetException;
import interfaces.Joueur;
import interfaces.controleurs.creationServeur.CreationServeurControleur;
import interfaces.controleurs.positionnementBateau.PlayGameControleur;
import interfaces.vue.Plateau;
import interfaces.vue.CreerOuRejoindre;
import interfaces.vue.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChoixControleur implements ActionListener {

    private ServeurChoix serveurChoix;
    private Plateau plateau;
    private PositionnementBateau positionnementBateau;
    private Player p;
    private PlayGameControleur playGameControleur;
    private CreationServeurControleur creationServeurControleur;
    private static Game game;


    public ChoixControleur(ServeurChoix serveurChoix, Plateau plateau, PositionnementBateau positionnementBateau, PlayGameControleur playGameControleur, CreationServeurControleur creationServeurControleur){
        this.serveurChoix = serveurChoix;
        this.plateau = plateau;
        this.playGameControleur = playGameControleur;
        this.creationServeurControleur = creationServeurControleur;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int[] listID = serveurChoix.getId();
        ArrayList<JRadioButton> listRadio = serveurChoix.getArray();

        int id = 0;
        Game theGame = null;

        for (int i=0; i<listID.length; i++){
            if (listRadio.get(i).isSelected()){
                id = listID[i];
            }
        }


        try {
            List<Game> listGames = Network.listInitializedGames("http://37.187.38.219/api/v0");

            for (int a = 0; a < listGames.size(); a++){
                if (listGames.get(a).getId()==id){
                    theGame = listGames.get(a);
                }
            }
            System.out.println(theGame);
            System.out.println(playGameControleur.getP());
            System.out.println(creationServeurControleur.getJoueur().getFlotte());

            Network.joinGame("http://37.187.38.219/api/v0",theGame, playGameControleur.getP(), creationServeurControleur.getJoueur().getFlotte());

        } catch (UnirestException | UncompleteFleetException | BadCoordException unirestException) {
            unirestException.printStackTrace();
        }

        this.game = theGame;
        
        
        PlateauImageComponent[][] list = plateau.getCaselist();


        List<IShip> listBateau = creationServeurControleur.getJoueur().getFlotte().getShips();

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
                            System.out.println("TEST: " + list[x][y].getId()[0] + " " + list[x][y].getId()[1]);
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



        this.serveurChoix.dispose();
        this.plateau.setVisible(true);
    }

    public Game getGame() {
        return game;
    }
}