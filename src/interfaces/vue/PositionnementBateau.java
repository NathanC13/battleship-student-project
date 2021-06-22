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



        JPanel jeuGauche = new JPanel();

        jeuGauche.setLayout(new BorderLayout());

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

        JPanel panelJouer = new JPanel(new FlowLayout());



        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new FlowLayout());
        JButton bouton1 = new JButton("Settings");
        JButton bouton2 = new JButton("Help");
        panel2.add(bouton1);
        panel2.add(bouton2);
        panel1.add(panel2,BorderLayout.EAST);






        JPanel placement = new JPanel();
        JLabel placerBateau = new JLabel("Placez vos Bateaux !");
        placement.add(placerBateau);

        JPanel haut = new JPanel(new BorderLayout());
        haut.add(panel1, BorderLayout.NORTH);
        haut.add(placement);


        JButton bateau1 = new JButton("bateau1");
        JButton bateau2 = new JButton("bateau2");
        JButton bateau3 = new JButton("bateau3");
        JButton bateau4 = new JButton("bateau4");
        JButton bateau5 = new JButton("bateau5");


        JPanel selectBateau = new JPanel(new GridLayout(7,1));
        selectBateau.add(bateau1);
        selectBateau.add(bateau2);
        selectBateau.add(bateau3);
        selectBateau.add(bateau4);
        selectBateau.add(bateau5);

        JPanel bas = new JPanel(new BorderLayout());
        JButton jouer = new JButton("JOUER");
        JPanel bas1 = new JPanel(new FlowLayout());
        bas1.add(jouer);
        bas.add(bas1, BorderLayout.CENTER);
        JButton clear = new JButton("clear");
        bas.add(clear, BorderLayout.EAST);


        jeuGauche.add(panelJouer, BorderLayout.SOUTH);

        jeuGauche.add(jeu1, BorderLayout.CENTER);


        principal.add(bas, BorderLayout.SOUTH);
        principal.add(selectBateau, BorderLayout.EAST);
        principal.add(haut, BorderLayout.NORTH);
        principal.add(jeuGauche, BorderLayout.CENTER);

        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(700,650));
        this.setContentPane(principal);

    }

}
