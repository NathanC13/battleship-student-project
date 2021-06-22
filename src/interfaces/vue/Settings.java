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

        JPanel panelsettings = new JPanel();
        panelsettings.setLayout(new BorderLayout());

        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bouton1 = new JButton("Back to the Game");
        panel2.add(bouton1);
        panel1.add(panel2,BorderLayout.NORTH);
        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bouton2 = new JButton("Restart a game");
        panel3.add(bouton2);
        panel1.add(panel3,BorderLayout.CENTER);
        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bouton3 = new JButton("Quit the Game");
        panel4.add(bouton3);
        panel1.add(panel4,BorderLayout.SOUTH);

        /*//panel1 = bouton1 au sud
        JPanel panel1 = new JPanel(new BorderLayout());
        JButton bouton1 = new JButton("Back to the Game");
        panel1.add(bouton1,BorderLayout.SOUTH);

        //panel2 = bouton2 au centre
        JPanel panel2= new JPanel(new BorderLayout());
        JButton bouton2 = new JButton("Restart a game");
        panel1.add(bouton2,BorderLayout.CENTER);

        //panel3 = bouton3 au nord
        JPanel panel3= new JPanel(new BorderLayout());
        JButton bouton3 = new JButton("Quit the Game");
        panel1.add(bouton3,BorderLayout.NORTH);
         */

        panelsettings.add(panel1,BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(400,110));
        this.setResizable(false);
        this.setContentPane(panelsettings);
    }

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
