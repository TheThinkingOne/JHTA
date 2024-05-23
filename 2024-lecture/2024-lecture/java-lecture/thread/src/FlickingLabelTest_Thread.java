import javax.swing.*;
import java.awt.*;
//Thread를 상속받은 걸로 바꿔서 구현해 보세요...
class FlickingLabel02 extends Thread {
    private int delay;
    private JLabel label;
    public FlickingLabel02(JLabel label, int delay) {
        this.delay = delay;
        this.label =label;
        label.setOpaque(true);
        label.setBackground(Color.ORANGE);
        this.start();
    }

    @Override
    public void run() {
        boolean isFlick=false;
        while(true) {
            System.out.println("왜 안바뀌나요?");
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            isFlick=!isFlick;
            if(isFlick) {
                label.setBackground(Color.GREEN);
            } else {
                label.setBackground(Color.ORANGE);
            }

        }
    }
}
public class FlickingLabelTest_Thread extends JFrame {
    public FlickingLabelTest_Thread() throws HeadlessException {
        this.setTitle("타이머");
        this.setSize(300,300);
        Container container = this.getContentPane();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel label01 = new JLabel("hello");
        container.add(label01);
        new FlickingLabel02(label01,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //thread 만들어야 함...
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new FlickingLabelTest_Thread();
    }
}