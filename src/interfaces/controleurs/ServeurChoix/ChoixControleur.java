package interfaces.controleurs.ServeurChoix;



import com.mashape.unirest.http.exceptions.UnirestException;
import info1.network.Game;
import info1.network.Network;
import info1.network.Player;
import info1.ships.ICoord;
import info1.ships.IShip;
import interfaces.Joueur;
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
import java.util.List;

public class ChoixControleur implements ActionListener {

    private ServeurChoix serveurChoix;
    private Plateau plateau;
    private PositionnementBateau positionnementBateau;

    public ChoixControleur(ServeurChoix serveurChoix, Plateau plateau, PositionnementBateau positionnementBateau){
        this.serveurChoix = serveurChoix;
        this.plateau = plateau;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        PlateauImageComponent[][] list = plateau.getCaselist();


        List<IShip> listBateau = positionnementBateau.getJoueur().getFlotte().getShips();

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
                            if ((list[x][y].getId()[0] == listCoord.get(bateau).getX()) && (list[x][y].getId()[1] == listCoord.get(bateau).getY())){
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
}