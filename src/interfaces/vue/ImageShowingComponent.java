package interfaces.vue;

import info1.ships.*;
import interfaces.Joueur;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Set;

public class ImageShowingComponent extends JComponent {

    private Image img;
    private int[] id;
    private PositionnementBateau fenetre;
    private int type;
    private Joueur joueur;
    private Ship boat;
    private int nb_sub;

    private MouseListener listener = new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            System.out.println("id: " + id[0] + " " +id[1]);

            ImageShowingComponent[][] list = fenetre.getCaselist();

            boolean horizontale = true;
            boolean vertical = true;
            

            int nombre_case = fenetre.getBateauSelected() + 1;

            for (int i=0; i<nombre_case; i++){
                if (id[1] + nombre_case<=10)
                    if(list[id[0]][id[1]+i].type == 1){
                        horizontale = false;
                    }
                if (id[0] + nombre_case<=10) {
                    if (list[id[0] + i][id[1]].type == 1) {
                        vertical = false;
                    }
                }
            }

            String a = null;
            String b = null;
            if (fenetre.getVertical().isSelected()) {
                a = (Character.toString((char) id[1] + 65) + ((id[0] + 1)));
                b = (Character.toString((char) id[1] + 65) + ((id[0] + 1) + nombre_case - 1));
            } else if (!fenetre.getVertical().isSelected()){
                a = (Character.toString((char) id[1] + 65) + ((id[0] + 1)));
                b = (Character.toString((char) id[1] + 65 + nombre_case - 1)) + (id[0] + 1) ;
            }

            System.out.println("id + case : " + id[0] + " " + id[1]);

            if (fenetre.getBateauSelected()!=-1) {

                System.out.println(Character.toString((char) id[1]+65) +((id[0]+1)) + " " + Character.toString((char) id[1]+65) +((id[0]+1)));
                System.out.println(a);
                System.out.println(b);

                int test = -1;

                if (fenetre.getBateauSelected() == 0){
                    try {
                        boat = new Submarine("submarine" + a +""+b, a);
                        test =4;
                    } catch (BadCoordException | CoordsBadShipException badCoordException) {
                        badCoordException.printStackTrace();
                    }
                } else if (fenetre.getBateauSelected() == 1){
                    try {
                        boat = new Destroyer("destroyer" + a +""+b, a, b);
                        test = 3;
                    } catch (BadCoordException | CoordsBadShipException badCoordException) {
                        badCoordException.printStackTrace();
                    }
                } else if (fenetre.getBateauSelected() == 2) {
                    try {
                        boat = new Cruiser("cruiser" + a +"" +b, a,b);
                        test = 2;
                    } catch (BadCoordException | CoordsBadShipException badCoordException) {
                        badCoordException.printStackTrace();
                    }
                } else if (fenetre.getBateauSelected() == 3) {
                    try {
                        boat = new Battleship("battleship" + a+ "" +b, a,b);
                        test = 1;
                    } catch (BadCoordException | CoordsBadShipException badCoordException) {
                        badCoordException.printStackTrace();
                    }
                } else if (fenetre.getBateauSelected() == 4) {
                    try {
                        boat = new AircraftCarrier("aircraftcarrier" + a +"" +b, a,b);
                        test = 1;
                    } catch (BadCoordException | CoordsBadShipException badCoordException) {
                        badCoordException.printStackTrace();
                    }
                }
          /*     for(int j = 0; j<=joueur.getFlotte().getShips().size();j++){
                   if(joueur.getFlotte().getShips().get(j)==){
                       nb_sub++;
                   }
               }*/
                Set<IShip> categorie = joueur.getFlotte().getShips(boat.getCategory());

                if(categorie.size() != test ) {



                    try {
                        Image image1 = ImageIO.read(new File("./img/cases_brouillon/case_bateau.png"));
                        for (int i = 0; i < nombre_case; i++) {


                            if (fenetre.getVertical().isSelected() && (id[0] + nombre_case <= 10) && vertical) {
                                ImageShowingComponent case0 = list[id[0] + i][id[1]];
                                case0.img = image1;
                                case0.setType(1);
                                joueur.addFlotte(boat);
                            } else if ((!fenetre.getVertical().isSelected()) && (id[1] + nombre_case <= 10) && horizontale) {
                                ImageShowingComponent case0 = list[id[0]][id[1] + i];
                                case0.img = image1;
                                case0.setType(1);
                                joueur.addFlotte(boat);
                            }
                        }
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
                

            }

            System.out.println(joueur.getFlotte());
            fenetre.invalidate(); //actualise la fenetre
            fenetre.validate();
            fenetre.repaint();
        }
    };

    ImageShowingComponent(int[] id, PositionnementBateau fenetre, Joueur joueur) {
        addMouseListener(listener);
        this.id = id;
        this.fenetre = fenetre;
        this.joueur = joueur;

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

    public void setType(int type) {
        this.type = type;
    }
}
