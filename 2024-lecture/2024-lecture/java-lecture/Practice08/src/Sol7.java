import javax.swing.*;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Sol7 extends JFrame {
    public Sol7() {
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(10,10,2,2));
        container.setSize(1000,1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label01 = new JLabel("수식입력");
        JTextField textField01 = new JTextField(10);

        container.add(label01);
        container.add(textField01);

        for (int i=0; i<16; i++) {
            JButton jButton = new JButton(Integer.toString(i));
            jButton.setSize(200,200);
            jButton.setLocation(50*(i%4), 50*(i/4));

            container.add(jButton);
        }

        JLabel jLabel02 = new JLabel("계산결과");
        JTextField textField02 = new JTextField(10);

        container.add(jLabel02);
        container.add(textField02);

        this.pack();
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new Sol7();
    }
}

