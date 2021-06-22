package interfaces.controleurs.settings;

import interfaces.vue.Settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackControleur implements ActionListener {

    private Settings settings;

    public BackControleur(Settings settings){
        this.settings = settings;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.settings.dispose();
    }
}
