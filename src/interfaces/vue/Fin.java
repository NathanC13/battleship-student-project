package interfaces.vue;

import interfaces.fin.Rejouer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Fin extends JFrame {
    private JButton rejouer;

    public Fin(String titre, int serv_response){
        super(titre);


        JPanel principal = new JPanel(new BorderLayout());

        ImageFin img = new ImageFin(serv_response);
        principal.add(img, BorderLayout.CENTER);

        rejouer = new JButton("Quitter");
        principal.add(rejouer, BorderLayout.SOUTH);



        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(720,420));
        this.setContentPane(principal);
        this.setResizable(false);

        Rejouer lafin = new Rejouer();
        fixListenerRejouer(lafin);

    }

    public void fixListenerRejouer(ActionListener action){
        rejouer.addActionListener(action);
    }


}
