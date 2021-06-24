package interfaces.controleurs.creationServeur;

import interfaces.vue.CreationServeur;
import interfaces.vue.Plateau;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreationServeurControleur implements ActionListener {

    private CreationServeur creationServeur;
    private Plateau plateau;
    public CreationServeurControleur(CreationServeur creationServeur, Plateau plateau){

        this.creationServeur = creationServeur;
        this.plateau = plateau;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        plateau.setVisible(true);
        creationServeur.dispose();

    }
}
