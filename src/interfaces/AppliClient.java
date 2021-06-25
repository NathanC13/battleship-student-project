package interfaces;

import interfaces.controleurs.creationServeur.CreationServeurControleur;
import interfaces.controleurs.menu.*;
import interfaces.controleurs.CreerOuRejoindre.*;
import interfaces.controleurs.ServeurChoix.*;
import interfaces.controleurs.plateaudejeu.Help2;
import interfaces.controleurs.positionnementBateau.*;
import interfaces.controleurs.settings.BackControleur;
import interfaces.controleurs.settings.QuitterSettingsControleur;
import interfaces.controleurs.settings.RestartControleur;
import interfaces.vue.*;

public class AppliClient {
    public static void main(String[] args) {

        Joueur joueur = new Joueur();

        MenuPrincipal fenetre = new MenuPrincipal("BattleShip Beeyard Edition© - Menu Principal ");
        PositionnementBateau positionnementBateau = new PositionnementBateau("BattleShip Beeyard Edition© - Choix des placements de bateaux ", joueur);
        Settings settings = new Settings("Settings ");

        CreerOuRejoindre CreerOuRejoindre = new CreerOuRejoindre("BattleShip Beeyard Edition© - Choix du mode ");
        ServeurChoix serveurChoix = new ServeurChoix("BattleShip Beeyard Edition© - Choix du serveur");

        CreationServeur creationServeur = new CreationServeur("BattleShip Beeyard Edition© - Choix du serveur");

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
        PlayGameControleur playGameControleur = new PlayGameControleur(positionnementBateau,CreerOuRejoindre);
        positionnementBateau.fixeListenerPlay(playGameControleur);
        HelpControleur helpControleur = new HelpControleur();
        Help2 help2 = new Help2();
        positionnementBateau.fixeListenerHelp(helpControleur);
        ClearControleur clearControleur = new ClearControleur(positionnementBateau,fenetre);
        positionnementBateau.fixeListenerClear(clearControleur);
        Bateau1Controleur bateau1Controleur = new Bateau1Controleur(positionnementBateau, joueur);
        positionnementBateau.fixeListenerBateau1(bateau1Controleur);
        Bateau2Controleur bateau2Controleur = new Bateau2Controleur(positionnementBateau, joueur);
        positionnementBateau.fixeListenerBateau2(bateau2Controleur);
        Bateau3Controleur bateau3Controleur = new Bateau3Controleur(positionnementBateau, joueur);
        positionnementBateau.fixeListenerBateau3(bateau3Controleur);
        Bateau4Controleur bateau4Controleur = new Bateau4Controleur(positionnementBateau, joueur);
        positionnementBateau.fixeListenerBateau4(bateau4Controleur);
        Bateau5Controleur bateau5Controleur = new Bateau5Controleur(positionnementBateau,joueur);
        positionnementBateau.fixeListenerBateau5(bateau5Controleur);


        Plateau plateau = new Plateau("BattleShip Beeyard Edition© - Jeu en cours ", positionnementBateau, serveurChoix, playGameControleur);
        //

        BackControleur backControleur = new BackControleur(settings);
        settings.fixeListenerBack(backControleur);
        RestartControleur restartControleur = new RestartControleur(settings, positionnementBateau, plateau);
        settings.fixeListenerRestart(restartControleur);
        QuitterSettingsControleur quitterSettingsControleur = new QuitterSettingsControleur(settings, positionnementBateau, CreerOuRejoindre, plateau, serveurChoix, fenetre);
        settings.fixeListenerQuitter(quitterSettingsControleur);


        plateau.fixeListenerSettings(settingsControleur);
        plateau.fixeListenerHelp2(help2);

        // listener pour rejoidnre ou creer
        RejoindreControleur rej = new RejoindreControleur(CreerOuRejoindre,serveurChoix);
        CreerOuRejoindre.fixeListenerRejoidnreControleur(rej);
        CreerControleur creer = new CreerControleur(CreerOuRejoindre, creationServeur);
        CreerOuRejoindre.fixeListenerCreerServeur(creer);

        // listener creation serveur
        CreationServeurControleur creationServeurControleur = new CreationServeurControleur(creationServeur, plateau, positionnementBateau, playGameControleur);
        creationServeur.fixeListenerCreationServeur(creationServeurControleur);

        ChoixControleur choixServeur = new ChoixControleur(serveurChoix,plateau, positionnementBateau, playGameControleur, creationServeurControleur);
        serveurChoix.fixeListenerChoixControleur(choixServeur);






        plateau.pack();
        settings.pack();
        positionnementBateau.pack();
        fenetre.pack();
        fenetre.setVisible(true);
        CreerOuRejoindre.pack();
        serveurChoix.pack();
        creationServeur.pack();
    }
}
