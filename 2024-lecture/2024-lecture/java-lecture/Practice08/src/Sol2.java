import javax.swing.*;
import java.awt.*;

public class Sol2 extends JFrame {
    public Sol2() {
        this.setTitle("BorderLayoutTest");
        Container container = this.getContentPane();
        JButton button01 = new JButton("North");
        JButton button02 = new JButton("South");
        JButton button03 = new JButton("East");
        JButton button04 = new JButton("West");
        JButton button05 = new JButton("Center");

        container.setLayout(new BorderLayout(5,7));
        container.add(button01, BorderLayout.NORTH);
        container.add(button02, BorderLayout.SOUTH);
        container.add(button03, BorderLayout.EAST);
        container.add(button04, BorderLayout.WEST);
        container.add(button05, BorderLayout.CENTER);

        this.setSize(300,300);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new Sol2();
    }
}
