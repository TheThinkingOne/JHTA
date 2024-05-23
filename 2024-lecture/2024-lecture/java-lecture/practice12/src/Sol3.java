import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;

class Clock implements Runnable {

    private JLabel clockLabel;

    public Clock(JLabel clockLabel) {
        this.clockLabel = clockLabel;
    }


    @Override
    public void run() {
        while (true) {
            LocalTime now = LocalTime.now();
            clockLabel.setText(now.toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

public class Sol3 extends JFrame {
    JLabel clock = new JLabel("00:00:00");
    public Sol3() throws HeadlessException {
        this.setTitle("현재시각");
        this.setSize(300,300);
        Container container = this.getContentPane();

        clock.setFont(new Font("맑은 고딕",Font.BOLD,48));
        clock.setHorizontalAlignment(JLabel.CENTER);
        container.add(clock);

        Clock clockThread = new Clock(clock);
        Thread th = new Thread(clockThread);
        th.start();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //thread 만들어야 함...
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Sol3();
    }
}
