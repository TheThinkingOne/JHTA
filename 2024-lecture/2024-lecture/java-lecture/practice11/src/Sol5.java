import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class ImagePanel05 extends JPanel {

    public ImagePanel05() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i=0; i<10; i++) {
            g.drawLine(40*(i+1),0,40*(i+1),400);
        }
        for (int i=0; i<10; i++) {
            g.drawLine(0,40*(i+1),400,40*(i+1));
        }

    }
}

public class Sol5 extends JFrame {
    ImagePanel05 graphicsPanel = new ImagePanel05();

    public Sol5() throws HeadlessException {
        this.setTitle("graphics");
        this.setSize(400, 400);
        //Container container = this.getContentPane();
        this.setContentPane(graphicsPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Sol5();
    }
}
