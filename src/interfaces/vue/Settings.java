package interfaces.vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Settings extends JFrame{

    private JButton bouton1;
    private JButton bouton2;
    private JButton bouton3;

    public Settings(String titre){
        super(titre);

        // création du panel settings pour accéder aux paramètres qui sont représentés par les 3 boutons ci-dessous
        JPanel panelsettings = new JPanel();
        panelsettings.setLayout(new BorderLayout());

        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bouton1 = new JButton("Retour au jeu");
        panel2.add(bouton1);
        panel1.add(panel2,BorderLayout.NORTH);
        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bouton2 = new JButton("Recommencer une partie");
        panel3.add(bouton2);
        panel1.add(panel3,BorderLayout.CENTER);
        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bouton3 = new JButton("Quitter la partie");
        panel4.add(bouton3);
        panel1.add(panel4,BorderLayout.SOUTH);

        panelsettings.add(panel1,BorderLayout.CENTER);

        //options de la Jframe
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(400,110));
        this.setResizable(false);
        this.setContentPane(panelsettings);
    }

    //liens listeners
    public void fixeListenerBack(ActionListener action){
        bouton1.addActionListener(action);
    }

    public void fixeListenerRestart(ActionListener action){
        bouton2.addActionListener(action);
    }



    public void fixeListenerQuitter(ActionListener action){
        bouton3.addActionListener(action);
    }
}
