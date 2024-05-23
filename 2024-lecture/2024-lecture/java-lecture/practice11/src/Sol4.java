import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

class ImagePanel04 extends JPanel {

    ImageIcon imageIcon = new ImageIcon("src/images/Full_Estelle_03.png");
    Image image = imageIcon.getImage();

    int posX = 100;
    int posY = 100;
    int scaleX = 100;
    int scaleY = 100;

    public ImagePanel04() {
        scaleX = image.getWidth(null);
        scaleY = image.getHeight(null);

        this.setFocusable(true);
        this.requestFocus();

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyChar() == '+') {
                    scaleX*=1.1;
                    scaleY*=1.1;
                }
                if(e.getKeyChar() == '-') {
                    scaleX*=0.9;
                    scaleY*=0.9;
                }
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 10, 10, scaleX,scaleY, null);
    }
}

public class Sol4 extends JFrame {
    ImagePanel04 graphicsPanel = new ImagePanel04();

    public Sol4() throws HeadlessException {
        this.setTitle("graphics");
        this.setSize(400, 600);
        //Container container = this.getContentPane();
        this.setContentPane(graphicsPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Sol4();
    }
}
