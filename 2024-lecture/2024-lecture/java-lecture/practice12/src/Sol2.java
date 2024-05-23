import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class CirclePanel extends JPanel implements  Runnable {
    private int posX;
    private int posY;
    //Thread thread = null;
    boolean isStart = true;

    public CirclePanel() {
        Thread thread = new Thread(this);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (isStart) {
                    thread.start();
                    isStart = false;
                }

            }
        });
    }


    @Override
    public void run() {
        while (true) {
            posX = (int)(Math.random()*this.getWidth());
            posY = (int)(Math.random()*this.getHeight());
            this.repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(255,0,0));
        g.drawOval(posX,posY,50,50);
    }
}
public class Sol2 extends JFrame {
    public Sol2() throws HeadlessException {
        this.setTitle("cex");
        this.setSize(500,500);
        this.setContentPane(new CirclePanel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Sol2();
    }
}
