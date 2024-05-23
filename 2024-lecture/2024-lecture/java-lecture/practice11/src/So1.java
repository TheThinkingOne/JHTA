import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ImagePanel extends JPanel {
    ImageIcon imageIcon = new ImageIcon("src/images/Full_DebiMarlene_00.png");
    Image image = imageIcon.getImage();

    private boolean isDraw = false;

    private JButton button = new JButton("HIDE/SHOW");

    public ImagePanel() {
        this.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 토글버튼입니다
                isDraw = !isDraw;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (isDraw) {
            g.drawImage(image,0,0,this);
        }
    }
}
public class So1 extends JFrame {
    ImagePanel03 graphicsPanel = new ImagePanel03();
    public So1() throws HeadlessException {
        this.setTitle("Sol1");
        this.setSize(2048,2048);
        this.setContentPane(graphicsPanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new So1();
    }
}
