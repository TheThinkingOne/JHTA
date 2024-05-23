import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventListener02 extends JFrame {
    public EventListener02() throws HeadlessException {
        this.setTitle("이벤트 리스너 첫번째");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        JButton btn = new JButton("만지지마");
        JButton btn02 = new JButton("만지지마");
        container.setLayout(new FlowLayout());
        container.add(btn);

        //ActionListener myActionListener = new MyActionListener();
        btn.addActionListener(new MyActionListener02());
        // 1. 외부 클래스를 따로 만들어서 처리...
        // 2. 내부 클래스 만들어서 처리

        // 사용자(user)가 이벤트를 발생시켰을때 어떻게 반응해야하는지...

        this.setSize(400,400);
        this.setVisible(true);
    }

    private class MyActionListener02 implements ActionListener {
        @Override()
        public void actionPerformed(ActionEvent e) {
            System.out.println("나는 내부 클래스로 만들어진 리스너입니다");
            EventListener02.this.setTitle("나는 내부 클래스에서 바꾼 타이틀 입니다");
        }
    }

    public static void main(String[] args) {
        new EventListener02();
    }
}
