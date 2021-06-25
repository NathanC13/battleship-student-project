package interfaces.vue;

import com.mashape.unirest.http.exceptions.UnirestException;
import info1.network.BadIdException;
import info1.network.Game;
import info1.network.Network;
import info1.ships.BadCoordException;
import info1.ships.Coord;
import info1.ships.UncompleteFleetException;
import interfaces.Joueur;
import interfaces.controleurs.ServeurChoix.ChoixControleur;
import interfaces.controleurs.creationServeur.CreationServeurControleur;
import interfaces.controleurs.positionnementBateau.PlayGameControleur;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JeuImageComponent extends JComponent {

    private Image img;
    private int[] id;
    private Plateau fenetre;
    private Joueur joueur;
    private Game game;
    private PlayGameControleur playGameControleur;
    private ServeurChoix serveurChoix;
    private PositionnementBateau positionnementBateau;

    private MouseListener listener = new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            System.out.println("id: " + id[0] + " " +id[1]);

            ChoixControleur choixControleur = new ChoixControleur(serveurChoix, fenetre, positionnementBateau, playGameControleur, null);

            game = choixControleur.getGame();

            if (game == null){
                CreationServeurControleur creationServeurControleur = new CreationServeurControleur(null,null,null,null);
                game = creationServeurControleur.getGame();
            }


            System.out.println("GAME: " + game);


            try {
                int serv_response = Network.getInfo("http://37.187.38.219/api/v0", game, playGameControleur.getP());

                if (serv_response == 10) {
                    int tour_response = Network.playOneTurn("http://37.187.38.219/api/v0", game, playGameControleur.getP(), new Coord(Character.toString((char) id[1] + 65) + ((id[0] + 1))));
                    if (tour_response == 1) {
                        img = ImageIO.read(new File("./img/case_bateau_touche.png"));
                        System.out.println("touche");
                    } else if (tour_response == 10) {
                        img = ImageIO.read(new File("./img/case_bateau_coule.png"));
                        System.out.println("Coulé");
                    } else if (tour_response == 0) {
                        System.out.println("Raté");
                        img = ImageIO.read(new File("./img/case_rate.png"));
                    } else {
                        System.out.println("reponse serveur : " + tour_response);
                    }
                } else if (serv_response == 100) {
                    System.out.println("WIN");
                    Fin fin = new Fin("WIN", serv_response);
                    fin.pack();
                    fin.setVisible(true);
                    fenetre.dispose();
                } else if (serv_response == -100){
                    System.out.println("PERDU");
                    Fin fin = new Fin("PERDU", serv_response);
                    fin.pack();
                    fin.setVisible(true);
                    fenetre.dispose();
                } else if (serv_response == -10){
                    System.out.println("Ce n'est pas votre tour");
                }

            } catch (UnirestException | BadIdException | BadCoordException | IOException unirestException) {
                unirestException.printStackTrace();
            }

            fenetre.invalidate(); //actualise la fenetre
            fenetre.validate();
            fenetre.repaint();


        }
    };

    JeuImageComponent(int[] id, Plateau fenetre, PositionnementBateau positionnementBateau, ServeurChoix serveurChoix, PlayGameControleur playGameControleur) {
        addMouseListener(listener);
        this.id = id;
        this.fenetre = fenetre;
        this.joueur = positionnementBateau.getJoueur();
        this.playGameControleur = playGameControleur;
        this.serveurChoix = serveurChoix;
        this.positionnementBateau = positionnementBateau;



        try {
            img = ImageIO.read(new File("./img/case_normale.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    // This method override will tell the LayoutManager how large this component
    // should be. We'll want to make this component the same size as the `img`.
    public Dimension getPreferredSize() {
        return new Dimension(img.getWidth(null), img.getHeight(null));
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int[] getId() {
        return id;
    }
}
