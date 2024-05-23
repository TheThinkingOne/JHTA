import javax.swing.*;
import java.awt.*;
class TimerThread extends Thread {
    private JLabel timerLabel;

    public TimerThread(JLabel timerLabel) {
        this.timerLabel = timerLabel;
    }

    @Override
    public void run() {
        int num=0;
        while(true) {
            num++;
            System.out.println(num);
            timerLabel.setText(Integer.toString(num));
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class TimerLabelTest extends JFrame {
    // 변수는 block scope {} 안에서만 영향을 끼친다
    JLabel timerLabel = new JLabel("0");

    public TimerLabelTest() throws HeadlessException {
        this.setTitle("타이머");
        this.setSize(300,300);
        Container container = this.getContentPane();

        timerLabel.setFont(new Font("맑은 고딕",Font.BOLD,48));
        timerLabel.setHorizontalAlignment(JLabel.CENTER);
        container.add(timerLabel);
        TimerThread timerThread = new TimerThread(timerLabel);
        timerThread.start();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //thread 만들어야 함...
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TimerLabelTest();
    }
}
