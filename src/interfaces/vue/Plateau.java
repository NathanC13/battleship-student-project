package interfaces.vue;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class Plateau extends JFrame{
    public Plateau(String titre){
        super(titre);

        JPanel plateau = new JPanel();
        plateau.setLayout(new BorderLayout());

        JPanel nord = new JPanel();
        nord.setLayout(new FlowLayout(FlowLayout.LEFT));

        JComboBox<String> combo = new JComboBox<>();
        combo.addItem("Game");
        combo.addItem("Restart");
        combo.addItem("Quitter");
        JButton setting = new JButton("Setting");
        JButton help = new JButton("Help");

        nord.add(combo);
        nord.add(setting);
        nord.add(help);



        JPanel sud = new JPanel();
        sud.setLayout(new FlowLayout());
        JLabel texte = new JLabel("Bateaux restants :                 ");
        JLabel texte1 = new JLabel("Touché(s) :                       ");
        JLabel texte3 = new JLabel("Fail(s) :                          ");

        sud.add(texte);
        sud.add(texte1);
        sud.add(texte3);




        plateau.add((sud),BorderLayout.SOUTH);
        plateau.add(nord,BorderLayout.NORTH);









        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(1200,700));
        this.setContentPane(plateau);


    }
}
