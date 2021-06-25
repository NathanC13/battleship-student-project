package interfaces.vue;

import com.mashape.unirest.http.exceptions.UnirestException;
import info1.network.BadIdException;
import info1.network.Game;
import info1.network.Network;
import interfaces.controleurs.plateaudejeu.*;

import interfaces.Joueur;
import interfaces.controleurs.positionnementBateau.PlayGameControleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class Plateau extends JFrame{


    private JButton Help2;
    private JButton setting;
    private PlateauImageComponent[][] listCase;
    private JLabel text1;
    private JLabel text3;

    public Plateau(String titre, PositionnementBateau positionnementBateau, ServeurChoix serveurChoix, PlayGameControleur playGameControleur){
        super(titre);

        listCase = new PlateauImageComponent[10][];

        for (int i = 0; i < 10; i++){
            listCase[i] = new PlateauImageComponent[10];
        }

        JPanel plateau = new JPanel();
        plateau.setLayout(new BorderLayout());

        JPanel nord = new JPanel();
        nord.setLayout(new FlowLayout(FlowLayout.RIGHT));

        setting = new JButton("Setting");
        Help2 = new JButton("Help");

        nord.add(setting);
        nord.add(Help2);

        //compteurs du jeu
        int cptbatrest = 0;
        int cptbattouche = 0;
        int cptrate = 0;

        JPanel sud = new JPanel();
        sud.setLayout(new FlowLayout());
        text1 = new JLabel("Touché(s) : "+ cptbattouche + "         ");
        text3 = new JLabel("Raté(s) : "+cptrate + "     ");

        sud.add(text1);
        sud.add(text3);

        JPanel east = new JPanel();
        east.setLayout(new GridLayout(10,10));

        for (int x=0; x<10; x++){
            for (int y=0; y<10; y++){

                JeuImageComponent img = new JeuImageComponent(new int[]{x,y}, this, positionnementBateau, serveurChoix, playGameControleur);

                east.add(img);
            }
        }
        JPanel center =  new JPanel();
        center.setLayout(new GridLayout(10,10));

        for (int x=0; x<10; x++){
            for (int y=0; y<10; y++){

                PlateauImageComponent img = new PlateauImageComponent(new int[]{x,y}, this, positionnementBateau);

                listCase[x][y] = img;
                center.add(img);
            }
        }

        JPanel centre = new JPanel();
        JLabel score = new JLabel(" 0 : 0");
        centre.add(score);
        plateau.add(centre,BorderLayout.CENTER);


        center.setBorder(BorderFactory.createTitledBorder("Vos bateaux : "));
        east.setBorder(BorderFactory.createTitledBorder("Ciblage : "));

        plateau.add((sud),BorderLayout.SOUTH);
        plateau.add(nord,BorderLayout.NORTH);
        plateau.add(east,BorderLayout.EAST);
        plateau.add(center,BorderLayout.WEST);









        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(1200,700));
        this.setContentPane(plateau);


    }

    public void fixeListenerSettings(ActionListener action){
        setting.addActionListener(action);
    }

    public void fixeListenerHelp2(ActionListener action){
        Help2.addActionListener(action);
    }

    public PlateauImageComponent[][] getCaselist() {
        return this.listCase;
    }


    public JLabel getText1() {
        return text1;
    }

    public JLabel getText3() {
        return text3;
    }
}
