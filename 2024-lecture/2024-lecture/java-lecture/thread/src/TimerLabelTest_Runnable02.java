import javax.swing.*;
import java.awt.*;
//class TimerRunnable02 implements Runnable {
//    private JLabel timerLabel;
//    public TimerRunnable02(JLabel timerLabel) {
//        this.timerLabel = timerLabel;
//    }
//
//    @Override
//    public void run() {
//        int num=0;
//        while(true) {
//            num++;
//            System.out.println(num);
//            timerLabel.setText(Integer.toString(num));
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//}

public class TimerLabelTest_Runnable02 extends JFrame implements Runnable {
    // 변수는 block scope {} 안에서만 영향을 끼친다
    JLabel timerLabel = new JLabel("0");

    public TimerLabelTest_Runnable02() throws HeadlessException {
        this.setTitle("타이머");
        this.setSize(300,300);
        Container container = this.getContentPane();

        timerLabel.setFont(new Font("맑은 고딕",Font.BOLD,48));
        timerLabel.setHorizontalAlignment(JLabel.CENTER);
        container.add(timerLabel);

        //TimerRunnable timerRunnable = new TimerRunnable(timerLabel);
        Thread th = new Thread(this); // this를 써서 Runnable을 구현한 자기 자신을 받으면 된다.
        // 위에가 또 다른 thread 구현 방법 중 하나
        th.start();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //thread 만들어야 함...
        this.setVisible(true);
    }

    // 생성자 없이 접근 가능하게 됨

    @Override
    public void run() {
        int num=0;
        while(true) {
            num++;
            System.out.println(num);
            timerLabel.setText(Integer.toString(num));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        new TimerLabelTest_Runnable02();
    }


}
