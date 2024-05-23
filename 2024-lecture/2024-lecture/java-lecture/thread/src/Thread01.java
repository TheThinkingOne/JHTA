import javax.swing.*;
import java.awt.*;

public class Thread01 extends Thread {
    // 스레드를 상속받으면 오버라이드 중 run 받을 수 있음
    Container container = new Container();
    JLabel jLabel = new JLabel("Timer");
    int i = 0;
    @Override
    public void run() {
        // 여기에 실행코드를 넣어준다.
        while (true) {
            i++;
            jLabel.setText(String.valueOf(i));
            try {
                sleep(1000); // sleep으로 기간 설정
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
                // run 은 try/catch 로 종료 설정 해줘야 함
            }
        }
    }



    public static void main(String[] args) {
        Thread01 thread01 = new Thread01();
        thread01.start(); // .start() 해야 돌아감

    }

}
