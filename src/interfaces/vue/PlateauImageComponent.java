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
import java.util.List;

public class PlateauImageComponent extends JComponent {

    private Image img;
    private int[] id;
    private Plateau fenetre;
    private Joueur joueur;

    private MouseListener listener = new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            System.out.println("id: " + id[0] + " " +id[1]);
        }
    };

    PlateauImageComponent(int[] id, Plateau fenetre, PositionnementBateau positionnementBateau) {
        addMouseListener(listener);
        this.id = id;
        this.fenetre = fenetre;
        this.joueur = positionnementBateau.getJoueur();

        try {
            img = ImageIO.read(new File("./img/case_normale.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

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
