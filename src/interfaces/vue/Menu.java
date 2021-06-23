package interfaces.vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    private JButton bouton0;
    private JButton bouton1;
    private JButton bouton2;
    private JButton bouton3;
    private JButton bouton4;

    public Menu(String titre){
        super(titre);

        //panel principal contenant les autres panels
        JPanel menuprincipal = new JPanel();
        menuprincipal.setLayout(new GridLayout(2,1));

        //panel borderlayout de la partie nord (3 boutons)
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

        //panel borderlayout de la partie sud (au nord)
        JPanel panel2 = new JPanel(new BorderLayout());
        JPanel panel22 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bouton2 = new JButton("Quitter");
        panel22.add(bouton2);
        panel2.add(panel22,BorderLayout.NORTH);

        //label du centre partie sud (sud)
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();
        JLabel label1 = new JLabel("Bienvenue dans la bataille navale - BeeYard Edition");
        this.bouton3 = new JButton("Français");
        this.bouton4 = new JButton("Belge");
        panel5.add(label1);
        panel3.add(panel5,BorderLayout.WEST);
        panel6.add(bouton3);
        panel6.add(bouton4);
        panel3.add(panel6,BorderLayout.EAST);
        panel2.add(panel3,BorderLayout.SOUTH);

        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout(FlowLayout.CENTER));
        ImageMenu img = new ImageMenu();
        panel4.add(img);
        panel1.add(panel4,BorderLayout.CENTER);


        //ajout des panels aux panel principal
        menuprincipal.add(panel1,BorderLayout.SOUTH);
        menuprincipal.add(panel2);


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