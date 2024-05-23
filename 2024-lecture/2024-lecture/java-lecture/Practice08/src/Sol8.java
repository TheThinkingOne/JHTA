import javax.swing.*;
import java.awt.*;

class NorthPanel02 extends JPanel {
    public NorthPanel02() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setOpaque(true);
        this.setBackground(Color.LIGHT_GRAY);
        this.add(new JLabel("수식입력"));
        this.add(new JTextField(20));
    }
}

class CenterPanel02 extends JPanel {
    public CenterPanel02() {
        this.setLayout(null);
        for(int i=0; i<20; i++) {
            JLabel jLabel = new JLabel("*");
            jLabel.setSize(20,20);
            jLabel.setForeground(Color.RED);
            int x = (int)(Math.random()*300)+50;
            int y = (int)(Math.random()*300)+50;

            jLabel.setLocation(x,y);
            this.add(jLabel);
        }

    }
}

class SouthPanel02 extends JPanel {
    // panel은 container 역할을 한다.
    public SouthPanel02() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setOpaque(true);
        this.setBackground(Color.LIGHT_GRAY);
        this.add(new JLabel("integer"));
        this.add(new JTextField(20));
    }
}

public class Sol8 extends JFrame {
    public Sol8() {
        this.setTitle("계산기");
        Container container = this.getContentPane();
        this.setSize(400,400);

        container.add(new NorthPanel02(),BorderLayout.NORTH);
        container.add(new CenterPanel02(),BorderLayout.CENTER);
        container.add(new SouthPanel02(),BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Sol8();
    }
}
