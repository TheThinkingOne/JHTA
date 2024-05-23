import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

class ImagePanel03 extends JPanel {
    ImageIcon imageIcon = new ImageIcon("src/images/Full_Estelle_03.png");
    Image image = imageIcon.getImage();

    int posX = 100;
    int posY = 100;

    public ImagePanel03() {
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                posX = e.getX() - image.getWidth(null)/2;
                posY = e.getY() - image.getHeight(null)/2;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, posX, posY, null);
    }
}

public class Sol3 extends JFrame {
    ImagePanel03 graphicsPanel = new ImagePanel03();

    public Sol3() throws HeadlessException {
        this.setTitle("graphics");
        this.setSize(400, 600);
        //Container container = this.getContentPane();
        this.setContentPane(graphicsPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Sol3();
    }
}
