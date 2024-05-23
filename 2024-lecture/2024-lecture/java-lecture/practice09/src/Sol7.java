import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Sol7 extends JFrame {
    public String jLabelText = "Love Java";
    private int fontSize = 20;
    private JLabel jLabel;
    public int count = 0;


    public Sol7() throws HeadlessException {
        Container container = this.getContentPane();
        container.setLayout(new FlowLayout());

        jLabel = new JLabel(jLabelText);

        this.setSize(400,400);
        this.setTitle("Sol7");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jLabel.setOpaque(true);
        jLabel.setBackground(Color.ORANGE);
        jLabel.setSize(80,30);
        jLabel.setFocusable(true);
        jLabel.setFont(new Font("MaruBuri-Bold", Font.BOLD, 30));
        jLabel.setLocation(200,200);

        container.add(jLabel);

        jLabel.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if (e.getWheelRotation()<0) {
                    decreaseFontSize();
                }
                else if (e.getWheelRotation()>0) {
                    increaseFontSize();
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
        new Sol7();
    }
}
