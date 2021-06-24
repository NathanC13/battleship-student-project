package interfaces.controleurs.ServeurChoix;



import com.mashape.unirest.http.exceptions.UnirestException;
import info1.network.Game;
import info1.network.Network;
import info1.network.Player;
import interfaces.vue.Plateau;
import interfaces.vue.CreerOuRejoindre;
import interfaces.vue.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ChoixControleur implements ActionListener {

    private ServeurChoix serveurChoix;
    private Plateau plateau;

    public ChoixControleur(ServeurChoix serveurChoix, Plateau plateau){
        this.serveurChoix = serveurChoix;
        this.plateau = plateau;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        this.serveurChoix.dispose();
        this.plateau.setVisible(true);
    }
}