package interfaces.vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreationServeur extends JFrame {

    private JButton bouton1;
    private JTextField text2;
    private JButton bouton3;
    private JButton bouton4;
    private JRadioButton fr;
    private JRadioButton be;
    private ButtonGroup group;

    public CreationServeur (String titre){
        super(titre);

        //panel principal contenant les autres panels
        JPanel menuprincipal = new JPanel();
        menuprincipal.setLayout(new GridLayout(2,1));

        //panel borderlayout de la partie nord (3 boutons)
        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel11 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panel12 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel1.add(panel12,BorderLayout.NORTH);
        text2 = new JTextField();
        panel11.add(text2);
        text2.setPreferredSize(new Dimension(355,55));
        text2.setBorder(BorderFactory.createTitledBorder("Veuillez entrer l'identifiant de la partie à créer"));
        panel1.add(panel11,BorderLayout.SOUTH);

        //panel borderlayout de la partie sud (au nord)
        JPanel panel2 = new JPanel(new BorderLayout());
        JPanel panel22 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bouton1 = new JButton("Créer la partie");
        panel22.add(bouton1);
        panel2.add(panel22,BorderLayout.NORTH);

        //label du centre partie sud (sud)
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();
        JLabel label1 = new JLabel("Bienvenue dans la bataille navale - BeeYard Edition");
        // this.bouton3 = new JButton("Français");
        //this.bouton4 = new JButton("Belge");





        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout(FlowLayout.CENTER));
        ImageMenu img = new ImageMenu();
        panel4.add(img);
        panel1.add(panel4,BorderLayout.NORTH);


        //ajout des panels aux panel principal
        menuprincipal.add(panel1,BorderLayout.NORTH);
        menuprincipal.add(panel2,BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(700,500));
        this.setContentPane(menuprincipal);
    }

    public void fixeListenerCreationServeur(ActionListener action){
        bouton1.addActionListener(action);
    }
}
