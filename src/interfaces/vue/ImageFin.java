package interfaces.vue;

import com.mashape.unirest.http.exceptions.UnirestException;
import info1.network.BadIdException;
import info1.network.Game;
import info1.network.Network;
import info1.network.Player;
import interfaces.Joueur;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class ImageFin extends JComponent {

    private Image img;

    ImageFin(int serv_response) {

        try {
            if (serv_response==100){
                img = ImageIO.read(new File("./img/VICTORY.jpg"));
            }
            else if(serv_response==-100){
                img = ImageIO.read(new File("./img/DEFEAT.jpg"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }


}
