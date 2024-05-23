import javax.swing.*;
import java.awt.*;

class ShakeFrame extends Thread {
    private Component component;

    private int dir = 0;
    private int gap = 2;

    public ShakeFrame(Component component) {
        this.component = component;
    }

    @Override
    public void run() {
        int xLocation = component.getX();
        int yLocation = component.getY();

        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            dir = Math.random()<0.5 ? 1 : -1;
            xLocation += dir*gap;
            dir = Math.random()<0.5 ? 1 : -1;
            yLocation += dir*gap;

            component.setLocation(xLocation,yLocation);
        }
    }
}

public class Sol4 extends JFrame {
    public Sol4() throws HeadlessException {
        this.setTitle("cex");
        this.setSize(500,500);
        // text만 출력하므로
        //this.setContentPane();
        this.setLocation(0,0);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        ShakeFrame shakeFrame = new ShakeFrame(this);
        shakeFrame.start();
    }

    public static void main(String[] args) {
        new Sol4();
    }
}
