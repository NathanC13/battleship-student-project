package interfaces.controleurs.settings;

import interfaces.vue.Settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestartControleur implements ActionListener {

    private Settings settings;

    public RestartControleur(Settings settings){
        this.settings = settings;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("RESTART");
    }
}
