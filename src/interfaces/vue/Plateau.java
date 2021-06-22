package interfaces.vue;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;


public class Plateau extends JFrame{


    private JButton help;
    private JButton setting;

    public Plateau(String titre){
        super(titre);

        JPanel plateau = new JPanel();
        plateau.setLayout(new BorderLayout());

        JPanel nord = new JPanel();
        nord.setLayout(new FlowLayout(FlowLayout.RIGHT));

        setting = new JButton("Setting");
        help = new JButton("Help");

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

        JPanel east = new JPanel();
        east.setLayout(new GridLayout(10,10));
        int id = 1;

        for (int x=0; x<10; x++){
            for (int y=0; y<10; y++){

                ImageShowingComponent img = new ImageShowingComponent(id, null);

                east.add(img);
                id++;
            }
        }
        JPanel center =  new JPanel();
        center.setLayout(new GridLayout(10,10));
        int id1 = 1;

        for (int x=0; x<10; x++){
            for (int y=0; y<10; y++){

                ImageShowingComponent img = new ImageShowingComponent(id1, null);

                center.add(img);
                id1++;
            }
        }




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

    public void fixeListenerHelp(ActionListener action){
        help.addActionListener(action);
    }
}
