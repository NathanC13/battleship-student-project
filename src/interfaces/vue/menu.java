package interfaces.vue;

import javax.swing.*;
import java.awt.*;

public class menu extends JFrame {

    public menu(String titre){
        super(titre);

        JPanel menuprincipal = new JPanel();
       // menuprincipal.setLayout(new BorderLayout());

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
        JButton bouton1 = new JButton("Nouvelle partie");
        panel1.add(bouton1);
        JButton bouton2 = new JButton("Quitter");
        panel1.add(bouton2);




        menuprincipal.add(panel1);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(1200,700));
        this.setContentPane(menuprincipal);
    }
}