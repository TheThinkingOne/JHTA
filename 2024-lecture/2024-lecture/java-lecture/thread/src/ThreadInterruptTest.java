import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TimerLabel implements Runnable {

    private JLabel label;
    private boolean isEnd = false; // 속성은 private, 변경은 method()로 한다.
    public TimerLabel(JLabel label) {
        this.label = label;
    }

    public void end() {
        isEnd = true;
    }

    @Override
    public void run() {
        int num = 0;
        while (true) {
            num++;
            label.setText(Integer.toString(num));
            try {
                Thread.sleep(100);
                if (isEnd) {
                    return;
                }
            } catch (InterruptedException e) {
                return; // 함수 종료
                //throw new RuntimeException(e);
            }
        }
    }
}

public class ThreadInterruptTest extends JFrame {
    private boolean isEnd = true;
    Thread thread = null;

    public ThreadInterruptTest() throws HeadlessException {
        this.setTitle("타이머");
        this.setSize(300,300);

        Container container = this.getContentPane();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel label01 = new JLabel("0");
        container.add(label01);
        label01.setFont(new Font("맑은 고딕",Font.BOLD,36));

        TimerLabel timerLabel = new TimerLabel(label01);
        thread = new Thread(timerLabel);
        thread.start(); // thread 시작

        // thread 는 재활용이 안됨!!!!!!!!!!!!

        JButton btn = new JButton("Timer Stop");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Thread는 종료하면 끝임, 재활용 불가능함
                // 또 쓰려면 다시 만들어서(new) 사용해야함
                if(isEnd) {
                    thread.interrupt();
                } else {
                    thread = new Thread(timerLabel); // 다시 만들어서 사용
                    thread.start();
                }
                isEnd = !isEnd;
                //thread.interrupt();
                // 예외 발생시켜야함
                System.out.println("클릭");
            }
        });
        container.add(btn);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ThreadInterruptTest();
    }

}
