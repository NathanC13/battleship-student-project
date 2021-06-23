package interfaces.controleurs.positionnementBateau;

import interfaces.vue.ImageShowingComponent;
import interfaces.vue.MenuPrincipal;
import interfaces.vue.PositionnementBateau;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ClearControleur implements ActionListener {

    private PositionnementBateau fenetre;
    private MenuPrincipal menu;

    public ClearControleur(PositionnementBateau fenetre, MenuPrincipal menu){
        this.fenetre = fenetre;
        this.menu = menu;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("CLEAR");

        ImageShowingComponent[][] tab = fenetre.getCaselist();

        try {
            Image img = ImageIO.read(new File("./img/case_normale.png"));

            for (int x = 0; x < 10; x++){
                for (int y=0; y < 10; y++){
                    tab[x][y].setType(0);
                    tab[x][y].setImg(img);
                }
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }

        fenetre.resetButton(menu);

        fenetre.getJoueur().clearFlotte();

        fenetre.invalidate(); //actualise la fenetre
        fenetre.validate();
        fenetre.repaint();


    }
}
