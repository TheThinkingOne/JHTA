import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Sol8_done extends JFrame {
    Random random = new Random(); // Math.random()
    boolean isPlay = true;
    int count = 0;

    JLabel[] labels = new JLabel[3]; //  숫자
    JLabel label = new JLabel("시작합니다."); // 결과 label

    public Sol8_done() throws HeadlessException {
        this.setTitle("카지노");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //4개의 label

        Container container = this.getContentPane();
        container.setLayout(null);
        container.addKeyListener(new MyKeyListener());
        int pos = 20;
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel("0");
            labels[i].setSize(100, 80);
            labels[i].setFont(new Font("맑은고딕", Font.BOLD, 50));
            labels[i].setOpaque(true);
            labels[i].setBackground(Color.CYAN);
            labels[i].setLocation(pos, 80);
            labels[i].setHorizontalAlignment(JLabel.CENTER); //글자 가운데 정렬
            pos += 120;
            container.add(labels[i]);
        }
        label.setLocation(50, 180);
        label.setSize(300, 50);
        label.setHorizontalAlignment(JLabel.CENTER);
        container.add(label);


        this.setSize(400, 400);
        this.setVisible(true);
        container.setFocusable(true); //키이벤트일때는 이거 두개 써야함...
        container.requestFocus();
    }
    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            // 이름쓸수있게하고  저장하기...
            // 장성호 5번
            // 이석원 20번
            // 코드 주시는 분에게 맛있는 간식을... 밤양갱

            if(e.getKeyCode()==KeyEvent.VK_R) {
                isPlay=true;
                labels[0].setText(Integer.toString(0));
                labels[1].setText(Integer.toString(0));
                labels[2].setText(Integer.toString(0));
                label.setText("게임을 시작합니다.");
            }
            if(e.getKeyCode()==KeyEvent.VK_ENTER && isPlay) {
                System.out.println("키가 눌러졌습니다.");
                int num01 = random.nextInt(5);
                int num02 = random.nextInt(5);
                int num03 = random.nextInt(5);
                labels[0].setText(Integer.toString(num01));
                labels[1].setText(Integer.toString(num02));
                labels[2].setText(Integer.toString(num03));
                count++;
                if(num01==num02 && num02==num03) {
                    label.setText("축하합니다."+count+"번째 만에 맞췄습니다.");
                    count = 0;
                    isPlay = false;
                } else {
                    label.setText("아쉽습니다.");
                }


//                for(JLabel label : labels) {
//                    num = random.nextInt(5);
//                    label.setText(Integer.toString(num));
//                }
            }
        }
    }
    public static void main(String[] args) {
        new Sol8_done();
    }
}
