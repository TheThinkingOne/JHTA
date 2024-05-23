import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sol5 extends JFrame {
    public String jLabelText = "Love Java";
    private int fontSize = 5;
    private JLabel jLabel;
    public int count = 0;


    public Sol5() throws HeadlessException {
        Container container = this.getContentPane();
        container.setLayout(new FlowLayout());

        jLabel = new JLabel(jLabelText);

        this.setSize(400,400);
        this.setTitle("Sol1");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jLabel.setOpaque(true);
        jLabel.setBackground(Color.ORANGE);
        jLabel.setSize(80,30);
        jLabel.setFocusable(true);
        jLabel.setFont(new Font("MaruBuri-Bold", Font.BOLD, 30));

        container.add(jLabel);

        jLabel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //count += 1;
                if (e.getKeyCode()==KeyEvent.VK_LEFT) {
                    increaseFontSize();
                }
                else if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
                    decreaseFontSize();
                }
            }
        });

        this.setVisible(true);
    }

    private void increaseFontSize() {
        fontSize += 5;
        jLabel.setFont(new Font("MaruBuri-Bold", Font.BOLD, fontSize));
    }

    private void decreaseFontSize() {
        if (fontSize > 5) { // 폰트 크기가 5보다 작아지지 않도록 체크
            fontSize -= 5;
            jLabel.setFont(new Font("MaruBuri-Bold", Font.BOLD, fontSize));
        }
    }

    public static void main(String[] args) {
        new Sol5();
    }
}
