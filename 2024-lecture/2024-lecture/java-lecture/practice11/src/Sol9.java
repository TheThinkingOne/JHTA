import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sol9 extends JFrame {


    private Color colors[] = {Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE};
    String titleList[] = {"apple", "cherry", "strawberry", "prune"};
    private JTextField tf[] = new JTextField[4];
    ImagePanel09 imagePanel09 = new ImagePanel09();
    InputPanel inputPanel = new InputPanel();

    class InputPanel extends JPanel {
        public InputPanel() {
            this.setBackground(Color.LIGHT_GRAY);
            for (int i = 0; i < 4; i++) {
                this.add(new JLabel(titleList[i]));
                tf[i] = new JTextField(5);
                this.add(tf[i]);
                tf[i].addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        super.keyReleased(e);
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            imagePanel09.repaint();
                        }
                    }
                });
            }
        }
    }

    class ImagePanel09 extends JPanel {
        public int arcList[] = new int[4]; //{0,0,0,0}
        @Override
        public void paintComponent(Graphics g) {
            int sum = 0;
            for (int i = 0; i < 4; i++) {
                arcList[i] = Integer.parseInt(tf[i].getText());
            }
            //130,240,10,20  (30/sum)*360
            super.paintComponent(g);
            for (int k = 0; k < 4; k++) {
                sum += arcList[k];
            }

            g.setFont(new Font("맑은 고딕",Font.BOLD,12));
            //g.setC
            for (int j = 0; j < 4; j++) {
                arcList[j] = Math.round((float) (arcList[j]) / sum * 360);
                g.setColor(colors[j]);
                g.drawString(titleList[j] + ":" + arcList[j] + "%",100+80*j,20);
            }
            System.out.println("======" + Arrays.toString(arcList));

            int start = 90;
            for (int i = 0; i < 4; i++) {
                g.setColor(colors[i]);
                g.fillArc(100, 100, 200, 200, start, arcList[i]);
                start += arcList[i];
            }
        }
    }

    public Sol9() {
//        inputPanel = new InputPanel();
//        imagePanel09 = new ImagePanel09();
        this.setTitle("graphics");
        this.setSize(500, 500);
        Container container = this.getContentPane();
        container.add(inputPanel, BorderLayout.NORTH);
        container.add(imagePanel09, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Sol9();
    }
}

