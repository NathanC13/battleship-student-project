package interfaces.vue;

import com.mashape.unirest.http.exceptions.UnirestException;
import info1.network.Game;
import info1.network.Network;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ServeurChoix extends JFrame {
    JButton okButton;
    JRadioButton jrb = null;
    private int[] id;
    private JRadioButton[] radioButtons;
    private ArrayList<JRadioButton> array = new ArrayList<>();


    public ServeurChoix(String titre){
        super(titre);

        //panelprincipal en borderlayout
        JPanel panelprincipal = new JPanel(new BorderLayout(4,4));
        panelprincipal.setBorder(new EmptyBorder(20,20,20,20));

        //panel gauche avec la liste des games et le bouton
        JPanel panelgauche = new JPanel();
        panelgauche.setLayout(new GridLayout(0,1,5,10));

        //récupération des id des parties joignables
        //Network.setProxy("srv-proxy-etu-2.iut-nantes.univ-nantes.prive", 3128);
        //Network.enableProxy(true);
        try {
            List<Game> game = Network.listInitializedGames("http://37.187.38.219/api/v0");
            id = new int[game.size()];
            radioButtons = new JRadioButton[game.size()];
            for (int i=0;i<game.size();i++){

                id[i] = game.get(i).getId();

            }
            List<JRadioButton> list = new ArrayList<>();
            ButtonGroup bg = new ButtonGroup();
            for (Game games : game){
                jrb = new JRadioButton(games.toString());
                list.add(jrb);
                bg.add(jrb);
                panelgauche.add(jrb);
                array.add(jrb);

            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }



        panelprincipal.add(new JScrollPane(panelgauche),BorderLayout.WEST);

         okButton = new JButton("Rejoindre");
        okButton.setMargin(new Insets(20, 50, 20, 50));
        okButton.setFont(okButton.getFont().deriveFont(50f));
        JPanel centerButtonPanel = new JPanel(new GridBagLayout());
        centerButtonPanel.setBorder(new EmptyBorder(50,50,50,50));
        centerButtonPanel.add(okButton);
        panelprincipal.add(centerButtonPanel, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(900,700));
        this.setContentPane(panelprincipal);
    }
    public void fixeListenerChoixControleur(ActionListener action){
        okButton.addActionListener(action);
    }

    public int[] getId() {
        return id;
    }

    public ArrayList<JRadioButton> getArray() {
        return array;
    }
}
