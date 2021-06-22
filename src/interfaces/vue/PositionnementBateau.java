package interfaces.vue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class PositionnementBateau extends JFrame {

    private JButton clear;
    private JButton jouer;
    private JButton bouton1;
    private JButton bouton2;

    public PositionnementBateau(String titre){
        super (titre);

        JPanel principal = new JPanel();

        principal.setLayout(new BorderLayout());



        JPanel jeuGauche = new JPanel();

        jeuGauche.setLayout(new BorderLayout());

        JPanel jeu1 = new JPanel();
        jeu1.setLayout(new GridLayout(11,11));



        JLabel labelA = new JLabel("A");
        JLabel labelB = new JLabel("B");
        JLabel labelC = new JLabel("C");
        JLabel labelD = new JLabel("D");
        JLabel labelE = new JLabel("E");
        JLabel labelF = new JLabel("F");
        JLabel labelG = new JLabel("G");
        JLabel labelH = new JLabel("H");
        JLabel labelI = new JLabel("I");
        JLabel labelJ = new JLabel("J");
        JLabel labelvide = new JLabel("");


        jeu1.add(labelA);
        jeu1.add(labelB);
        jeu1.add(labelC);
        jeu1.add(labelD);
        jeu1.add(labelE);
        jeu1.add(labelF);
        jeu1.add(labelG);
        jeu1.add(labelH);
        jeu1.add(labelI);
        jeu1.add(labelJ);
        jeu1.add(labelvide);

        int id = 1;

        for (int x=0; x<10; x++){
            String text = new String();
            text = String.valueOf(x+1);
            jeu1.add(new JLabel(text));
            for (int y=0; y<10; y++){

                ImageShowingComponent img = new ImageShowingComponent(id);

                jeu1.add(img);
                id++;
            }

        }

        JPanel panelJouer = new JPanel(new FlowLayout());



        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new FlowLayout());
        bouton1 = new JButton("Settings");
        bouton2 = new JButton("Help");
        panel2.add(bouton1);
        panel2.add(bouton2);
        panel1.add(panel2,BorderLayout.EAST);






        JPanel placement = new JPanel();
        JLabel placerBateau = new JLabel("Placez vos Bateaux !");
        placement.add(placerBateau);

        JPanel haut = new JPanel(new BorderLayout());
        haut.add(panel1, BorderLayout.NORTH);
        haut.add(placement);

        Icon IconBateau1 = new ImageIcon("./img/bateau_1case.png");
        JButton bateau1 = new JButton(IconBateau1);
        Icon IconBateau2 = new ImageIcon("./img/bateau_2cases.png");
        JButton bateau2 = new JButton(IconBateau2);
        Icon IconBateau3 = new ImageIcon("./img/bateau_3cases.png");
        JButton bateau3 = new JButton(IconBateau3);
        Icon IconBateau4 = new ImageIcon("./img/bateau_4cases.png");
        JButton bateau4 = new JButton(IconBateau4);
        Icon IconBateau5 = new ImageIcon("./img/bateau_5cases.png");
        JButton bateau5 = new JButton(IconBateau5);



        JTextField pseudo = new JTextField("");
        JLabel espace = new JLabel();

        JPanel selectBateau = new JPanel(new GridLayout(8,1));

        selectBateau.add(pseudo);
        selectBateau.add(espace);
        selectBateau.add(bateau1);
        selectBateau.add(bateau2);
        selectBateau.add(bateau3);
        selectBateau.add(bateau4);
        selectBateau.add(bateau5);


        JPanel bas = new JPanel(new BorderLayout());
        jouer = new JButton("JOUER");
        JPanel bas1 = new JPanel(new FlowLayout());
        bas1.add(jouer);
        bas.add(bas1, BorderLayout.CENTER);
        clear = new JButton("clear");
        bas.add(clear, BorderLayout.EAST);


        jeuGauche.add(panelJouer, BorderLayout.SOUTH);

        jeuGauche.add(jeu1, BorderLayout.CENTER);


        principal.add(bas, BorderLayout.SOUTH);
        principal.add(selectBateau, BorderLayout.EAST);
        principal.add(haut, BorderLayout.NORTH);
        principal.add(jeuGauche, BorderLayout.CENTER);

        //this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(700,650));
        this.setContentPane(principal);

    }

    public void fixeListenerSettings(ActionListener action){
        bouton1.addActionListener(action);
    }

    public void fixeListenerPlay(ActionListener action){
        jouer.addActionListener(action);
    }

    public void fixeListenerHelp(ActionListener action){
        bouton2.addActionListener(action);
    }

    public void fixeListenerClear(ActionListener action){
        clear.addActionListener(action);
    }
}
