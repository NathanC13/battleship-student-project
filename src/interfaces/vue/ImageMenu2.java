package interfaces.vue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class ImageMenu2 extends JComponent {

    private Image img;

    ImageMenu2() {


        try {
            img = ImageIO.read(new File("./img/logo_beeyard_reduit.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    // This method override will tell the LayoutManager how large this component
    // should be. We'll want to make this component the same size as the `img`.
    public Dimension getPreferredSize() {
        return new Dimension(img.getWidth(null), img.getHeight(null));
    }
}
