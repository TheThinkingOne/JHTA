import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class TimerPanel extends JPanel {
    private JLabel timerLabel;
    private int remainingTime;
    private Timer timer;

    public TimerPanel() {
        this.timerLabel = new JLabel();
        this.remainingTime = 30;
        this.timer = new Timer();
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(timerLabel);
        timerLabel.setText("30");
        startTimer();
    }

    private void startTimer() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateTimer();
            }
        }, 0, 1000); // 매초마다 타이머 업데이트
    }

    private void updateTimer() {
        if (remainingTime > 0) {
            remainingTime--;
            timerLabel.setText("남은 시간: " + remainingTime + "초");
        } else {
            timerLabel.setText("시간 초과!");
        }
    }
}

