package interfaces.controleurs.settings;

import interfaces.AppliClient;
import interfaces.vue.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuitterSettingsControleur implements ActionListener {

    private Settings settings;
    private PositionnementBateau pos;
    private CreerOuRejoindre creerourej;
    private ServeurChoix servchoix;
    private Plateau plateau;
    private MenuPrincipal menu;

    public QuitterSettingsControleur(Settings settings, PositionnementBateau pos, CreerOuRejoindre creerourej, Plateau plateau, ServeurChoix servchoix, MenuPrincipal menu){
        this.settings = settings;
        this.pos = pos;
        this.plateau = plateau;
        this.creerourej = creerourej;
        this.menu = menu;
        this.servchoix = servchoix;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.settings.dispose();
        this.pos.dispose();
        this.creerourej.dispose();
        this.servchoix.dispose();
        this.plateau.dispose();
        this.menu.dispose();
        System.exit(-1);
    }
}
