package interfaces.vue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ImageShowingComponent extends JComponent {

    private Image img;
    private int id;
    private PositionnementBateau fenetre;

    private MouseListener listener = new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            System.out.println(id);

            ArrayList<ImageShowingComponent> list = fenetre.getCaselist();



            int nombre_case = fenetre.getBateauSelected() + 1;



            if (fenetre.getBateauSelected()!=-1) {

                try {
                    img = ImageIO.read(new File("./img/case_bateau.png"));

                } catch (IOException exception) {
                    exception.printStackTrace();
                }

                for (int i = 0; i < nombre_case; i++) {
                    ImageShowingComponent case0 = list.get(id - 1 + i);
                    case0.img = img;
                }
            }


            fenetre.invalidate(); //actualise la fenetre
            fenetre.validate();
            fenetre.repaint();
        }
    };

    ImageShowingComponent(int id, PositionnementBateau fenetre) {
        addMouseListener(listener);
        this.id = id;
        this.fenetre = fenetre;

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
}
