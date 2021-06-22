package interfaces.controleurs.positionnementBateau;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearControleur implements ActionListener {

    public ClearControleur(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("CLEAR");
    }
}
