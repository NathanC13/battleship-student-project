package interfaces.vue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class ImageShowingComponent extends JComponent {

    private Image img;
    private int[] id;
    private PositionnementBateau fenetre;
    private int type;

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

            System.out.println("Verticale: " + horizontale);
            System.out.println("Horizontale: " + vertical);

            System.out.println(nombre_case);

            Image test = list[id[0]][id[1]].img;

            System.out.println(test);

            System.out.println("id + case : " + id[0] + " " + id[1]);

            if (fenetre.getBateauSelected()!=-1) {
                System.out.println("test");
                    try {
                        Image image1 = ImageIO.read(new File("./img/case_bateau.png"));
                        for (int i = 0; i < nombre_case; i++) {


                            if (fenetre.getVertical().isSelected() && (id[0] + nombre_case<=10) && vertical) {
                                ImageShowingComponent case0 = list[id[0] + i][id[1]];
                                case0.img = image1;
                                case0.setType(1);
                            }else if ((!fenetre.getVertical().isSelected()) && (id[1] + nombre_case<=10) && horizontale){
                                ImageShowingComponent case0 = list[id[0]][id[1] + i];
                                case0.img = image1;
                                case0.setType(1);
                            }
                        }
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }

            }


            fenetre.invalidate(); //actualise la fenetre
            fenetre.validate();
            fenetre.repaint();
        }
    };

    ImageShowingComponent(int[] id, PositionnementBateau fenetre) {
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

    public void setImg(Image img) {
        this.img = img;
    }

    public void setType(int type) {
        this.type = type;
    }
}
