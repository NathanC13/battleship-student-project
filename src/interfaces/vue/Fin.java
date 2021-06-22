package interfaces.vue;

import javax.swing.*;
import java.awt.*;

public class Fin extends JFrame {

    public Fin(String titre){
        super(titre);


        JPanel principal = new JPanel(new BorderLayout());

        ImageFin img = new ImageFin();
        principal.add(img, BorderLayout.CENTER);

        JButton rejouer = new JButton("Rejouer");
        principal.add(rejouer, BorderLayout.SOUTH);



        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(720,420));
        this.setContentPane(principal);
        this.setResizable(false);
    }

}
