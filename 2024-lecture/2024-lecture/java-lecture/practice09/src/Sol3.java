import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sol3 extends JFrame {

    public int count = 0;
    public Sol3() throws HeadlessException {
        Container container = this.getContentPane();
        container.setLayout(new FlowLayout());

        JLabel jLabel = new JLabel("Love Java");

        this.setSize(400,400);
        this.setTitle("Sol1");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jLabel.setOpaque(true);
        jLabel.setBackground(Color.ORANGE);
        jLabel.setSize(80,30);
        jLabel.setFocusable(true);

        container.add(jLabel);

        jLabel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                count += 1;
                if (e.getKeyCode()==KeyEvent.VK_LEFT) {
                    if (count % 2 == 1) {
                        jLabel.setText("avaJ evol");
                    } else if (count % 2 == 0){
                        jLabel.setText("Love Java");
                    }
                }
            }
        });

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Sol3();
    }
}
