package interfaces.controleurs.settings;

import interfaces.AppliClient;
import interfaces.vue.Plateau;
import interfaces.vue.PositionnementBateau;
import interfaces.vue.Settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestartControleur implements ActionListener {

    private Settings settings;
    private PositionnementBateau positionnementBateau;
    private Plateau plateau;

    public RestartControleur(Settings settings, PositionnementBateau positionnementBateau, Plateau plateau){
        this.settings = settings;
        this.positionnementBateau = positionnementBateau;
        this.plateau = plateau;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("RESTART");
        AppliClient.main(new String[1]);
        settings.dispose();
        positionnementBateau.dispose();
        plateau.dispose();
    }
}
