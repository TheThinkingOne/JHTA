import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Sol4_lectureVer extends JFrame {

    public String jLabelText= "Love Java";

    public static String shift(String s) {
        return s.charAt(s.length()-1)+s.substring(0, s.length()-1);
    }

    public String concat(String s) {
        return s.substring(1) + s.charAt(0);
    }

    public Sol4_lectureVer() throws HeadlessException {
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
                if (e.getKeyCode()==KeyEvent.VK_LEFT) {
                    jLabelText = concat(jLabelText);
                    jLabel.setText(jLabelText);
                }
            }
        });

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Sol4();
    }
}

