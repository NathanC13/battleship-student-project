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

    private MouseListener listener = new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            System.out.println("id: " + id[0] + " " +id[1]);


            try {
                int serv_response = Network.getInfo("http://37.187.38.219/api/v0", game, playGameControleur.getP());

                if (serv_response == 10){
                    int tour_response = Network.playOneTurn("http://37.187.38.219/api/v0", game, playGameControleur.getP(), new Coord(Character.toString((char) id[1] + 65) + ((id[0] + 1))));
                    if (tour_response==1){
                        img = ImageIO.read(new File("./img/case_bateau_touche.png"));
                    } else  if (tour_response==10){
                        img = ImageIO.read(new File("./img/case_bateau_coule.png"));
                    } else if (tour_response==0){
                        System.out.println("Raté");
                    } else{
                        System.out.println("reponse serveur : " + tour_response);
                    }
                }

            } catch (UnirestException | BadIdException | BadCoordException | IOException unirestException) {
                unirestException.printStackTrace();
            }


        }
    };

    JeuImageComponent(int[] id, Plateau fenetre, PositionnementBateau positionnementBateau, ServeurChoix serveurChoix, PlayGameControleur playGameControleur) {
        addMouseListener(listener);
        this.id = id;
        this.fenetre = fenetre;
        this.joueur = positionnementBateau.getJoueur();
        this.playGameControleur = playGameControleur;



        int[] listID = serveurChoix.getId();
        ArrayList<JRadioButton> listRadio = serveurChoix.getArray();

        int idGame = 0;


        for (int i=0; i<listID.length; i++){
            if (listRadio.get(i).isSelected()){
                idGame = listID[i];
            }
        }


        try {
            List<Game> listGames = Network.listInitializedGames("http://37.187.38.219/api/v0");

            for (int a = 0; a < listGames.size(); a++){
                if (listGames.get(a).getId()==idGame){
                    game = listGames.get(a);
                }
            }
        } catch (UnirestException unirestException) {
            unirestException.printStackTrace();
        }




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
