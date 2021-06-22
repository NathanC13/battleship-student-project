package interfaces.vue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class PlateauJeu extends JFrame {

    private int id;

    public PlateauJeu(String titre){
        super (titre);
        this.id = id;

        //panel principal en borderlayout
        JPanel principal = new JPanel();
        principal.setLayout(new BorderLayout());

        //panel en flowlayout pour les boutons
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton bouton1 = new JButton("Settings");
        JButton bouton2 = new JButton("Help");
        panel1.add(bouton1);
        panel1.add(bouton2);

        //panel en gridlayout pour les deux *100 images
        JPanel panel2 = new JPanel(new GridLayout(1,2));
        JPanel panel21 = new JPanel(new FlowLayout());

        id = 1;
        for (int x=0; x<10; x++){
            for (int y=0; y<10; y++){

                ImageShowingComponent img = new ImageShowingComponent(id);

                panel21.add(img);
                id++;
            }
        }
        JPanel panel22 = new JPanel(new FlowLayout());
        id = 1;
        for (int x=0; x<10; x++){
            for (int y=0; y<10; y++){

                ImageShowingComponent img = new ImageShowingComponent(id);

                panel22.add(img);
                id++;
            }
        }
        panel2.add(panel21);
        panel2.add(panel22);



        principal.add(panel1,BorderLayout.NORTH);
        principal.add(panel2,BorderLayout.CENTER);

        //this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(1250,950));
        this.setContentPane(principal);

    }

}
