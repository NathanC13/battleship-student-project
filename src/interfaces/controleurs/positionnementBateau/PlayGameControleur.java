package interfaces.controleurs.positionnementBateau;

import com.mashape.unirest.http.exceptions.UnirestException;
import info1.network.Network;
import info1.network.Player;
import interfaces.vue.Plateau;
import interfaces.vue.PositionnementBateau;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayGameControleur implements ActionListener {

    private PositionnementBateau positionnementBateau;
    private Plateau plateau;

    public PlayGameControleur(PositionnementBateau positionnementBateau, Plateau plateau){
        this.positionnementBateau = positionnementBateau;
        this.plateau = plateau;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //création du joueur
        Player p = new Player(positionnementBateau.getPseudo());
        //inscription du joueur
        try {
            Network.suscribeNewPlayer(null,p);
        } catch (UnirestException unirestException) {
            unirestException.printStackTrace();
        }


        this.plateau.setVisible(true);
        this.positionnementBateau.dispose();
    }
}
