import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Sol2_bard extends JFrame {

    private boolean isDragging = false;

    public Sol2_bard() throws HeadlessException {
        this.setTitle("Sol2");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new FlowLayout());
        container.setBackground(Color.green);

        JLabel label = new JLabel("당신을 기억해요.");
        label.setOpaque(true);
        label.setSize(80, 30);
        container.add(label);

        this.setSize(400, 400);
        this.setVisible(true);

        container.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                isDragging = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isDragging = false;
                container.setBackground(Color.green);
                label.setText("Waiting Mouse Dragging");
            }
        });

        container.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (isDragging) {
                    container.setBackground(Color.ORANGE);
                    label.setText("Movse Dragging");
                }
            }
        });
    }

    public static void main(String[] args) {
        new Sol2();
    }
}

