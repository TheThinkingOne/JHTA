import javax.swing.*;
import java.awt.*;

class FlickingLabel extends JLabel implements Runnable {
    private int delay;

    public FlickingLabel(String str, int delay) {
        this.delay = delay;
        this.setText(str);
        this.setOpaque(true);
        this.setBackground(Color.ORANGE);
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        boolean isFlick = false;
        while (true) {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            isFlick=!isFlick;
            if (isFlick) {
                this.setBackground(Color.GREEN);
            } else {
                this.setBackground(Color.ORANGE);
            }
        }
    }

}

public class FlickingLabelTest extends JFrame {
    // 변수는 block scope {} 안에서만 영향을 끼친다
    public FlickingLabelTest() throws HeadlessException {
        this.setTitle("타이머");
        this.setSize(300,300);
        Container container = this.getContentPane();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        container.add(new FlickingLabel("삶을",500));
        container.add(new FlickingLabel("속삭여줬어",300));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    // 생성자 없이 접근 가능하게 됨



    public static void main(String[] args) {
        new FlickingLabelTest();
    }


}