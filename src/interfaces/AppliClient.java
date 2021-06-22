package interfaces;

import interfaces.controleurs.menu.NewGameControleur;
import interfaces.controleurs.menu.QuitterControleur;
import interfaces.controleurs.positionnementBateau.SettingsControleur;
import interfaces.controleurs.settings.BackControleur;
import interfaces.controleurs.settings.QuitterSettingsControleur;
import interfaces.controleurs.settings.RestartControleur;
import interfaces.vue.*;

public class AppliClient {
    public static void main(String[] args) {

        Menu fenetre = new Menu("test");
        PositionnementBateau positionnementBateau = new PositionnementBateau("test");
        Settings settings = new Settings("test");

        QuitterControleur quitterControleur = new QuitterControleur(fenetre);
        fenetre.fixeListenerQuitter(quitterControleur);
        NewGameControleur newGameControleur = new NewGameControleur(fenetre, positionnementBateau);
        fenetre.fixeListenerNewGame(newGameControleur);


        SettingsControleur settingsControleur = new SettingsControleur(positionnementBateau, settings);
        positionnementBateau.fixeListenerSettings(settingsControleur);


        BackControleur backControleur = new BackControleur(settings);
        settings.fixeListenerBack(backControleur);
        RestartControleur restartControleur = new RestartControleur(settings);
        settings.fixeListenerRestart(restartControleur);
        QuitterSettingsControleur quitterSettingsControleur = new QuitterSettingsControleur(settings);
        settings.fixeListenerQuitter(quitterSettingsControleur);




        settings.pack();
        positionnementBateau.pack();
        fenetre.pack();
        fenetre.setVisible(true);
    }
}
