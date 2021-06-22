package interfaces.vue;

import javax.swing.*;
import java.awt.*;

public class Jeu extends JFrame {

    public Jeu(String titre){
        super(titre);

        JPanel interfacejeu = new JPanel();
        interfacejeu.setLayout(new BorderLayout());

        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new FlowLayout());
        JComboBox<String> combo = new JComboBox<>();
        combo.addItem("Game");
        combo.addItem("Restart");
        combo.addItem("Quit");
        JButton bouton1 = new JButton("Settings");
        JButton bouton2 = new JButton("Help");
        panel1.add(combo,BorderLayout.WEST);
        panel2.add(bouton1);
        panel2.add(bouton2);
        panel1.add(panel2,BorderLayout.EAST);

        interfacejeu.add(panel1,BorderLayout.NORTH);

        /*
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JComboBox<String> combo = new JComboBox<>();
        combo.addItem("Game");
        combo.addItem("Restart");
        combo.addItem("Quit");
        JButton bouton1 = new JButton("Settings");
        JButton bouton2 = new JButton("Help");
        panel1.add(combo);
        panel1.add(bouton1);
        panel1.add(bouton2);


        interfacejeu.add(panel1);
         */

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(700,500));
        this.setContentPane(interfacejeu);

    }

}
