package interfaces.controleurs.positionnementBateau;

import interfaces.vue.PositionnementBateau;
import interfaces.vue.Settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsControleur implements ActionListener {

    private PositionnementBateau fenetre;
    private Settings settings;

    public SettingsControleur(PositionnementBateau fenetre, Settings settings){
        this.fenetre = fenetre;
        this.settings = settings;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.settings.setVisible(true);
    }
}
