import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventListener03 extends JFrame {
    public EventListener03() throws HeadlessException {
        this.setTitle("이벤트 리스너 첫번째");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        JButton btn = new JButton("만지지마");
        JButton btn02 = new JButton("만지지마");
        container.setLayout(new FlowLayout());
        container.add(btn);
        container.add(btn02);

        // 익명 클래스 => 생성과 동시에 사용, 한번만 사용됨
        // 익명 클래스는 무조건 따로 만들어야 함
        // 인터페이스를 상속받았는데 구현해야 하는 메서드가 하나일때 람다식으로 바꿔쓸 수 있음
        btn02.addActionListener(e ->
            System.out.println("만지지마제발")
        );

        //ActionListener myActionListener = new MyActionListener();
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 다른 버튼에 적용이 안되는 단점이 있음
                System.out.println("click");
            }
        });

        this.setSize(400,400);
        this.setVisible(true);
    }


    public static void main(String[] args) {
        new EventListener03();
    }
}
