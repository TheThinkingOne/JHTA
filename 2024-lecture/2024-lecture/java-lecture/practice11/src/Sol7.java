import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

class ImagePanel07 extends JPanel {
    private List<Integer> mouseX = new ArrayList<>();
    private List<Integer> mouseY = new ArrayList<>();

    public ImagePanel07() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                mouseX.add(e.getX());
                mouseY.add(e.getY());
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        int total = mouseX.size();
        int x [] = new int[total];
        int y [] = new int[total];

        for(int i=0;i<total;i++) {
            x[i] = mouseX.get(i);
            y[i] = mouseY.get(i);
        }

        super.paintComponent(g);
        g.drawPolygon(x,y,total);
    }
}

public class Sol7 extends JFrame {
    ImagePanel07 graphicsPanel = new ImagePanel07();

    public Sol7() throws HeadlessException {
        this.setTitle("graphics");
        this.setSize(600, 600);
        //Container container = this.getContentPane();
        this.setContentPane(graphicsPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Sol7();
    }
}
