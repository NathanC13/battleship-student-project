package interfaces.controleurs.menu;

import interfaces.vue.MenuPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuitterControleur implements ActionListener {
    
    private MenuPrincipal fenetre;
    
    public QuitterControleur(MenuPrincipal fenetre){
        this.fenetre = fenetre;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.fenetre.dispose();
        System.exit(-1);
    }
}
