package interfaces;

import interfaces.controleurs.menu.*;
import interfaces.controleurs.positionnementBateau.*;
import interfaces.controleurs.settings.BackControleur;
import interfaces.controleurs.settings.QuitterSettingsControleur;
import interfaces.controleurs.settings.RestartControleur;
import interfaces.vue.*;

public class AppliClient {
    public static void main(String[] args) {


        MenuPrincipal fenetre = new MenuPrincipal("BattleShip Beeyard Edition© - Menu Principal ");
        PositionnementBateau positionnementBateau = new PositionnementBateau("BattleShip Beeyard Edition© - Choix des placements de bateaux ");
        Settings settings = new Settings("Settings ");
        Plateau plateau = new Plateau("BattleShip Beeyard Edition© - Jeu en cours ");

        QuitterControleur quitterControleur = new QuitterControleur(fenetre);
        fenetre.fixeListenerQuitter(quitterControleur);
        NewGameControleur newGameControleur = new NewGameControleur(fenetre, positionnementBateau);
        fenetre.fixeListenerNewGame(newGameControleur);
        InformationsControleur info = new InformationsControleur(fenetre);
        fenetre.fixeListenerInformation(info);
        BelgeControleur be = new BelgeControleur(fenetre);
        fenetre.fixeListenerBelge(be);
        FrancaisControleur fr = new FrancaisControleur(fenetre);
        fenetre.fixeListenerFrancais(fr);


        SettingsControleur settingsControleur = new SettingsControleur(positionnementBateau, settings);
        positionnementBateau.fixeListenerSettings(settingsControleur);
        PlayGameControleur playGameControleur = new PlayGameControleur(positionnementBateau, plateau);
        positionnementBateau.fixeListenerPlay(playGameControleur);
        HelpControleur helpControleur = new HelpControleur();
        positionnementBateau.fixeListenerHelp(helpControleur);
        ClearControleur clearControleur = new ClearControleur(positionnementBateau,fenetre);
        positionnementBateau.fixeListenerClear(clearControleur);
        Bateau1Controleur bateau1Controleur = new Bateau1Controleur(positionnementBateau);
        positionnementBateau.fixeListenerBateau1(bateau1Controleur);
        Bateau2Controleur bateau2Controleur = new Bateau2Controleur(positionnementBateau);
        positionnementBateau.fixeListenerBateau2(bateau2Controleur);
        Bateau3Controleur bateau3Controleur = new Bateau3Controleur(positionnementBateau);
        positionnementBateau.fixeListenerBateau3(bateau3Controleur);
        Bateau4Controleur bateau4Controleur = new Bateau4Controleur(positionnementBateau);
        positionnementBateau.fixeListenerBateau4(bateau4Controleur);
        Bateau5Controleur bateau5Controleur = new Bateau5Controleur(positionnementBateau);
        positionnementBateau.fixeListenerBateau5(bateau5Controleur);



        BackControleur backControleur = new BackControleur(settings);
        settings.fixeListenerBack(backControleur);
        RestartControleur restartControleur = new RestartControleur(settings);
        settings.fixeListenerRestart(restartControleur);
        QuitterSettingsControleur quitterSettingsControleur = new QuitterSettingsControleur(settings);
        settings.fixeListenerQuitter(quitterSettingsControleur);


        plateau.fixeListenerSettings(settingsControleur);
        plateau.fixeListenerHelp(helpControleur);




        plateau.pack();
        settings.pack();
        positionnementBateau.pack();
        fenetre.pack();
        fenetre.setVisible(true);
    }
}
