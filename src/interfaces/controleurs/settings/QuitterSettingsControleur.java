package interfaces.controleurs.settings;

import interfaces.vue.Settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuitterSettingsControleur implements ActionListener {

    private Settings settings;

    public QuitterSettingsControleur(Settings settings){
        this.settings = settings;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("reviens au menu principal");
    }
}
