package interfaces.vue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class PositionnementBateau extends JFrame {

    public PositionnementBateau(String titre){
        super (titre);


        JPanel principal = new JPanel();

        principal.setLayout(new BorderLayout());

        JPanel jeu1 = new JPanel();
        jeu1.setLayout(new GridLayout(10,10));



        int id = 1;

        for (int x=0; x<10; x++){
            for (int y=0; y<10; y++){

                ImageShowingComponent img = new ImageShowingComponent(id);

                jeu1.add(img);
                id++;
            }
        }

        JLabel text = new JLabel("Choisir l'emplacement de ses bateaux");
        principal.add(text, BorderLayout.SOUTH);

        JButton button = new JButton("bouton");
        JButton button1 = new JButton("bouton1");
        JLabel labelTop = new JLabel("topLabel");


        JPanel test = new JPanel(new FlowLayout());
        test.add(jeu1);

        principal.add(button, BorderLayout.EAST);
        principal.add(button1, BorderLayout.WEST);
        principal.add(labelTop, BorderLayout.NORTH);
        principal.add(jeu1, BorderLayout.CENTER);


        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(700,650));
        this.setContentPane(principal);

    }

}
