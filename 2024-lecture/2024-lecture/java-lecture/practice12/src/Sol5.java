import javax.swing.*;
import java.awt.*;

class ShakeLabel extends Thread {
    private Component component;
    private int dir=0;
    private int gap = 2;
    public ShakeLabel(Component component) {
        this.component = component;
    }

    @Override
    public void run() {
        int x = component.getX();
        int y = component.getY();

        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            dir = Math.random()<0.5 ? 1 : -1;
            x+=dir*gap;
            dir = Math.random()<0.5 ? 1 : -1;
            y+=dir*gap;
            component.setLocation(x,y);
        }
    }
}

public class Sol5 extends JFrame {
    public Sol5() throws HeadlessException {
        this.setTitle("타이머");
        this.setSize(500,500);
        Container container = this.getContentPane();
        container.setLayout(null);
        JLabel label = new JLabel("나 떨고 있니?");
        label.setFont(new Font("맑은 고딕",Font.BOLD,24));
        label.setSize(200,50);
        label.setLocation(200,200);
        container.add(label);
        //this.setLocation(300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        ShakeLabel shakeLabel = new ShakeLabel(label);
        shakeLabel.start();
    }

    public static void main(String[] args) {
        new Sol5();
    }
}