import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.util.Calendar;

class Clock02 extends JLabel implements Runnable {
    private Thread clockThread;

    public Clock02() {
        this.setFont(new Font("맑은고딕",Font.BOLD,40));
        makeTime();
        this.setHorizontalAlignment(JLabel.CENTER);
        clockThread = new Thread(this);
        clockThread.start();
    }

    private void makeTime() {
//        Calendar calendar = Calendar.getInstance();
//
//        int hour = calendar.get(Calendar.HOUR_OF_DAY);
//        int min = calendar.get(Calendar.MINUTE);
//        int sec = calendar.get(Calendar.SECOND);
        LocalTime localTime = LocalTime.now();
        int hour = localTime.getHour();
        int min = localTime.getMinute();
        int sec = localTime.getSecond();

        this.setText(addZero(hour)+":"+addZero(min)+":"+addZero(sec));
    }

    private String addZero(int num) {
        if (num<10) return "0" + num;
        else return Integer.toString(num);
//        if (hour<10) hour = Integer.parseInt("0" + hour);
//        if (min<10) min = Integer.parseInt("0" + min);
//        if (sec<10) sec = Integer.parseInt("0" + sec);
    }


    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            makeTime();
        }
    }
}

public class Sol3_lectureVer extends JFrame {
    public Sol3_lectureVer() throws HeadlessException {
        this.setTitle("cex");
        this.setSize(500,500);
        // text만 출력하므로
        //this.setContentPane();
        Container container = this.getContentPane();
        container.add(new Clock02());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Sol3_lectureVer();
    }
}
