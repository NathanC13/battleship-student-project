package interfaces.controleurs.menu;

import interfaces.vue.Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuitterControleur implements ActionListener {
    
    private Menu fenetre;
    
    public QuitterControleur(Menu fenetre){
        this.fenetre = fenetre;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.fenetre.dispose();
    }
}
