import javax.swing.*;
import java.awt.*;

public class NullLayoutTest extends JFrame {
    public NullLayoutTest() {
        this.setTitle("null layout");
        this.setSize(300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(null); // null 은 자유로운 배치 대신 위치랑 크기는 사용자가 전부 세팅해줘야 함
        JLabel label01 = new JLabel("나는 레이블1");
        JLabel label02 = new JLabel("나는 레이블2");

        // 크기 정하고 위치 정해야지만 된다.
        label01.setSize(100,30);
        label02.setSize(100,30);
        label02.setLocation(0,30);
        //container.add(label01);
        //container.add(label02);
        for (int i=0; i<9; i++) {
            JButton jButton = new JButton(Integer.toString(i+1));
            jButton.setSize(50,50); //
            jButton.setLocation(50*(i%3),50*(i/3));
            container.add(jButton);
        }
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new NullLayoutTest();
    }
}
