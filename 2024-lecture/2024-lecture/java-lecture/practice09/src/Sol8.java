//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//
//public class Sol8 extends JFrame {
//    public String jLabelText = "Love Java";
//    private int fontSize = 20;
//    public int count = 0;
//
//    public JLabel labels[] = new JLabel[3];
//    public JLabel resultLabel;
//
//    public Sol8() throws HeadlessException {
//        Container container = this.getContentPane();
//        container.setLayout(new FlowLayout());
//
//        labels[0] = new JLabel("겜");
//        labels[1] = new JLabel("블");
//        labels[2] = new JLabel("링");
//
//        resultLabel = new JLabel("운명만큼이나 중요한건 우리의 의지죠.");
//
//        this.setSize(400,400);
//        this.setTitle("Sol8");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        container.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                if(e.getKeyCode()==KeyEvent.VK_ENTER) {
//                    labels[0].setText(Integer.toString((int)(Math.random()*400)));
//                    labels[1].setText(Integer.toString((int)(Math.random()*400)));
//                    labels[2].setText(Integer.toString((int)(Math.random()*400)));
//                    gamble();
//                }
//            }
//        });
//
//        for (int i=0; i<3; i++) {
//            container.add(labels[i]);
//            labels[i].setOpaque(true);
//            labels[i].setFont(new Font("MaruBuri-Bold", Font.BOLD, 30));
//            labels[i].setBackground(Color.MAGENTA);
//            labels[i].setSize(80,30);
//        }
//
//        this.setVisible(true);
//    }
//
//    private void gamble() {
//        int num1 = labels[0].getText();
//        int num2 = labels[1].getText();
//        int num3 = labels[2].getText();
//
//        if (num1 == num2 & num2 == num3 & num3 == num1) {
//            resultLabel.setText("말하는대로 이루어져라!");
//        }
//        else {
//            resultLabel.setText("괜찮아~ 서툴러도 돼.");
//        }
//    }
//
//    public static void main(String[] args) {
//        new Sol8();
//    }
//}
