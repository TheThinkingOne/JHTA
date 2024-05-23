import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Sol8_lectureVer extends JFrame {
    Random random = new Random();
    boolean isPlay = true;
    JLabel[] labels = new JLabel[3];
    JLabel resultLabel = new JLabel("시작합니다.");
    int count = 0;

    public Sol8_lectureVer() throws HeadlessException {
        Container container = this.getContentPane();
        container.setLayout(null);
        this.setTitle("Sol8");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.addKeyListener(new MyKeyListener());
        container.setFocusable(true);
        container.requestFocus();

        resultLabel.setLocation(50,180);

        int pos = 0;

        this.setVisible(true);
    }
    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER & isPlay) {
                System.out.println("키가 눌러졌습니다.");
                int num01 = random.nextInt(5);
                int num02 = random.nextInt(5);
                int num03 = random.nextInt(5);

                labels[0].setText(Integer.toString(num01));
                labels[1].setText(Integer.toString(num02));
                labels[2].setText(Integer.toString(num03));

                count++;

                if (num01 == num02 & num02 == num03) {
                    resultLabel.setText("말하는대로 이루어져라!" + count + "번 만에 맞췄어!");
                    count = 0;
                    isPlay = false;
                } else resultLabel.setText("괜찮아~ 서툴러도 돼~");

//                for (JLabel label : labels) {
//                    num = random.nextInt(5);
//                    label.setText(Integer.toString(num));
//                }

            }



        }
    }


    public static void main(String[] args) {
        new Sol8_lectureVer();
    }
}
