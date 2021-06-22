package interfaces;

import interfaces.controleurs.menu.NewGameControleur;
import interfaces.controleurs.menu.QuitterControleur;
import interfaces.controleurs.positionnementBateau.HelpControleur;
import interfaces.controleurs.positionnementBateau.PlayGameControleur;
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
        Plateau plateau = new Plateau("test");

        QuitterControleur quitterControleur = new QuitterControleur(fenetre);
        fenetre.fixeListenerQuitter(quitterControleur);
        NewGameControleur newGameControleur = new NewGameControleur(fenetre, positionnementBateau);
        fenetre.fixeListenerNewGame(newGameControleur);


        SettingsControleur settingsControleur = new SettingsControleur(positionnementBateau, settings);
        positionnementBateau.fixeListenerSettings(settingsControleur);
        PlayGameControleur playGameControleur = new PlayGameControleur(positionnementBateau, plateau);
        positionnementBateau.fixeListenerPlay(playGameControleur);
        HelpControleur helpControleur = new HelpControleur();
        positionnementBateau.fixeListenerHelp(helpControleur);


        BackControleur backControleur = new BackControleur(settings);
        settings.fixeListenerBack(backControleur);
        RestartControleur restartControleur = new RestartControleur(settings);
        settings.fixeListenerRestart(restartControleur);
        QuitterSettingsControleur quitterSettingsControleur = new QuitterSettingsControleur(settings);
        settings.fixeListenerQuitter(quitterSettingsControleur);




        plateau.pack();
        settings.pack();
        positionnementBateau.pack();
        fenetre.pack();
        fenetre.setVisible(true);
    }
}
