package interfaces.controleurs.CreerOuRejoindre;


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

public class RejoindreControleur implements ActionListener {

    private CreerOuRejoindre creerOuRejoindre;
    private ServeurChoix serveurChoix;

    public RejoindreControleur(CreerOuRejoindre creerOuRejoindre, ServeurChoix serveurChoix){
        this.creerOuRejoindre = creerOuRejoindre;
        this.serveurChoix = serveurChoix;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        this.creerOuRejoindre.dispose();
        this.serveurChoix.setVisible(true);
    }
}
