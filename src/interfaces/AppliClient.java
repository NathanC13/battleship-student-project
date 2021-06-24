package interfaces;

import interfaces.controleurs.creationServeur.CreationServeurControleur;
import interfaces.controleurs.menu.*;
import interfaces.controleurs.CreerOuRejoindre.*;
import interfaces.controleurs.ServeurChoix.*;
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
        Plateau plateau = new Plateau("BattleShip Beeyard Edition© - Jeu en cours ", positionnementBateau);
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

        // listener pour rejoidnre ou creer
        RejoindreControleur rej = new RejoindreControleur(CreerOuRejoindre,serveurChoix);
        CreerOuRejoindre.fixeListenerRejoidnreControleur(rej);
        CreerControleur creer = new CreerControleur(CreerOuRejoindre, creationServeur);
        CreerOuRejoindre.fixeListenerCreerServeur(creer);

        // listener creation serveur
        CreationServeurControleur creationServeurControleur = new CreationServeurControleur(creationServeur, plateau, positionnementBateau);
        creationServeur.fixeListenerCreationServeur(creationServeurControleur);

        ChoixControleur choixServeur = new ChoixControleur(serveurChoix,plateau, positionnementBateau);
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
