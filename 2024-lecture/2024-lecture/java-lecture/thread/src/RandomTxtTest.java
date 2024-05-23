import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RandomTxtTest extends JFrame implements Runnable {
    JLabel label = null;
    Container container = null;
    Thread thread = null;
    boolean isEnd = false;
    public RandomTxtTest() {
        this.setTitle("random text!!");
        this.setSize(500,500);

        thread = new Thread(this);
        thread.start();
        container = this.getContentPane();
        container.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                // 마우스 작동시 멈추기
                //thread.interrupt();
                isEnd = true;
            }
        });
        container.setLayout(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(300);
                if(isEnd) {
                    container.removeAll();
                    label = new JLabel("finish");
                    container.add(label);
                    label.setLocation(200,200);
                    label.setSize(80,30);
                    container.repaint();
                    return;
                }
            } catch (InterruptedException e) {
                return;
                //throw new RuntimeException(e);
            }

            JLabel label = new JLabel("JAVA");
            label.setSize(80,80);

            label.setSize(80,30);
            label.setLocation((int)(Math.random()*container.getWidth()) -80 , (int)(Math.random()*container.getHeight()) -80);

            container.add(label);
            container.repaint();
        }
    }

    public static void main(String[] args) {
        new RandomTxtTest();
    }

}
