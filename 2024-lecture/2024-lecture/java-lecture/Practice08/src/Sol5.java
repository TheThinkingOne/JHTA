import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Sol5 extends JFrame {
    public Sol5() {
        this.setTitle("Ten Color Buttons Frame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,1000);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(4,4));

        Random random = new Random();

        for (int i=0; i<16; i++) {
            JButton jButton = new JButton(Integer.toString(i));
            jButton.setSize(200,200);
            jButton.setLocation(50*(i%4), 50*(i/4));

            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            Color randomColor = new Color(red,green,blue);
            jButton.setBackground(randomColor);
            container.add(jButton);
        }
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Sol5();
    }
}
