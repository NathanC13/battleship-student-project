package interfaces.controleurs.positionnementBateau;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpControleur implements ActionListener {



    public HelpControleur(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("HELP");
    }
}
