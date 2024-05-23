import javax.swing.*;
import java.awt.*;

public class Sol6 extends JFrame {
    public Sol6() {
        Container container = this.getContentPane();
        container.setLayout(null);
        this.setSize(400,400);

        for(int i=0; i<20; i++) {
            JLabel jLabel = new JLabel(Integer.toString(i));
            jLabel.setSize(20,20);

            int x = (int)(Math.random()*300)+50;
            int y = (int)(Math.random()*300)+50;
            jLabel.setOpaque(true);
            jLabel.setBackground(Color.ORANGE);
            jLabel.setLocation(x,y);

            container.add(jLabel);
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Sol6();
    }
}
