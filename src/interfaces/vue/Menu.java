package interfaces.vue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Menu extends JFrame {

    private JButton bouton0;
    private JButton bouton1;
    private JButton bouton2;

    public Menu(String titre){
        super(titre);

        //panel principal contenant les autres panels
        JPanel menuprincipal = new JPanel();
        menuprincipal.setLayout(new GridLayout(2,1));

        //panel borderlayout de la partie nord
        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel11 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panel12 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        this.bouton0 = new JButton("Informations");
        panel12.setBackground(Color.GRAY);
        panel12.add(bouton0);
        panel1.add(panel12,BorderLayout.NORTH);
        bouton1 = new JButton("Nouvelle partie");
        panel11.add(bouton1);
        panel1.add(panel11,BorderLayout.SOUTH);

        //panel borderlayout de la partie sud
        JPanel panel2 = new JPanel(new BorderLayout());
        JPanel panel22 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bouton2 = new JButton("Quitter");
        panel22.add(bouton2);
        panel2.add(panel22);

        //label du centre partie nord
        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel label1 = new JLabel("Bienvenue dans la bataille navale - BeeYard Edition");
        panel3.add(label1);
        panel2.add(panel3,BorderLayout.SOUTH);

        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout(FlowLayout.CENTER));
        ImageMenu img = new ImageMenu();
        panel4.add(img);
        panel1.add(panel4,BorderLayout.CENTER);

        //ajout des panels aux panel principal
        menuprincipal.add(panel1,BorderLayout.SOUTH);
        menuprincipal.add(panel2,BorderLayout.NORTH);


        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(700,500));
        this.setContentPane(menuprincipal);
    }

    public void fixeListenerQuitter(ActionListener action){
        bouton2.addActionListener(action);
    }

    public void fixeListenerNewGame(ActionListener action){
        bouton1.addActionListener(action);
    }
}