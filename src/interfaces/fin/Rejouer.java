package interfaces.fin;

import interfaces.AppliClient;
import interfaces.vue.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rejouer implements ActionListener{

    private Settings settings;
    private Plateau plateau;
    private PositionnementBateau posbat;
    private MenuPrincipal menuPrincipal;
    private CreerOuRejoindre creerOuRejoindre;
    private CreationServeur creationServeur;
    private ServeurChoix serveurChoix;

    public Rejouer (){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(-1);
    }
}
