import javax.swing.*;
import java.awt.*;

class NorthPanel extends JPanel {
    public NorthPanel() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setOpaque(true);
        this.setBackground(Color.LIGHT_GRAY);
        this.add(new JLabel("수식입력"));
        this.add(new JTextField(20));
    }
}

class CenterPanel extends JPanel {
    public CenterPanel() {
        this.setLayout(new GridLayout(4,4,5,5));
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
        for(int i=0; i<10; i++) {
            JButton jButton = new JButton((Integer.toString(i)));
            this.add(jButton);
        }
        this.add(new JButton("CE"));
        this.add(new JButton("계산"));
        this.add(new JButton("+"));
        this.add(new JButton("-"));
        this.add(new JButton("*"));
        this.add(new JButton("X"));
        this.add(new JButton("/"));
    }
}

class SouthPanel extends JPanel {
    public SouthPanel() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setOpaque(true);
        this.setBackground(Color.LIGHT_GRAY);
        this.add(new JLabel("수식입력"));
        this.add(new JTextField(20));
    }
}

public class Sol7_lectureVer extends JFrame {
    public Sol7_lectureVer() {
        this.setTitle("계산기");
        Container container = this.getContentPane();
        this.setSize(400,400);

        container.add(new NorthPanel(),BorderLayout.NORTH);
        container.add(new CenterPanel(),BorderLayout.CENTER);
        container.add(new SouthPanel(),BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Sol7_lectureVer();
    }
}