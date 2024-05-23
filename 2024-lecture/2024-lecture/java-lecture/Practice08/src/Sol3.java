import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Sol3 extends JFrame {
    public Sol3() {
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(1,10)); // 수평 그리드 레이아웃

        Random random = new Random();

        for (int i=0; i<10; i++) {
            JButton jButton = new JButton(Integer.toString(i));
            jButton.setSize(50,50);
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            Color randomColor = new Color(red, green, blue);

            jButton.setBackground(randomColor);
            container.add(jButton);
        }
        this.setVisible(true);
        this.setSize(500,500);
    }

    public static void main(String[] args) {
        new Sol3();
    }
}
