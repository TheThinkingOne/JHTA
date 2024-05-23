import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Sol1 extends JFrame {

    private int count = 0;

    public Sol1() throws HeadlessException {
        Container container = this.getContentPane();
        container.setLayout(new FlowLayout());

        JLabel jLabel = new JLabel("Love Java");

        this.setSize(400,400);
        this.setTitle("Sol1");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jLabel.setOpaque(true);
        jLabel.setBackground(Color.ORANGE);
        jLabel.setSize(80,30);


        container.add(jLabel);


        jLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jLabel.setText("사랑해");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel.setText("Love Java");
            }
        });

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Sol1();
    }


}
