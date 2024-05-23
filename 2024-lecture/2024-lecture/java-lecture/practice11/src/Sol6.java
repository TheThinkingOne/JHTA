import javax.swing.*;
import java.awt.*;

class ImagePanel06 extends JPanel {

    public ImagePanel06() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int j=0;
        for (int i=0; i<10; i++) {
            int x1 [] = {200,0+j,200,400-j};
            int y1 [] = {0+j,200,400-j,200};
            g.drawPolygon(x1,y1,4);
            j+=10;

        }
    }
}

public class Sol6 extends JFrame {
    ImagePanel06 graphicsPanel = new ImagePanel06();

    public Sol6() throws HeadlessException {
        this.setTitle("graphics");
        this.setSize(600, 600);
        //Container container = this.getContentPane();
        this.setContentPane(graphicsPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Sol6();
    }
}
