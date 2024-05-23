import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

class ImagePanel02 extends JPanel {
    ImageIcon imageIcon = new ImageIcon("src/images/Full_Estelle_03.png");
    Image image = imageIcon.getImage();

    int posX = 100;
    int posY = 100;

    public ImagePanel02() {
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                posX = e.getX() - 10;
                posY = e.getY() - 10;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
        g.setColor(new Color(255,0,0));
        g.fillOval(posX,posY,20,20);

    }
}

public class Sol2 extends JFrame {
    ImagePanel02 graphicsPanel = new ImagePanel02();

    public Sol2() throws HeadlessException {
        this.setTitle("graphics");
        this.setSize(400, 600);
        //Container container = this.getContentPane();
        this.setContentPane(graphicsPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Sol2();
    }
}