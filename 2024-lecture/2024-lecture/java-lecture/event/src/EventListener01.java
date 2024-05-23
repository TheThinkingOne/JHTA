import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyActionListener implements ActionListener {
    @Override()
    public void actionPerformed(ActionEvent e) {

        JButton btn = (JButton)e.getSource(); // 이벤트 소스
        String str = btn.getText();
        if(str.equals("만지지마")) btn.setText("만지지마아아아아아아아아아");
        else btn.setText("만지지마");

    }
}

public class EventListener01 extends JFrame {
    public EventListener01() throws HeadlessException {
        this.setTitle("이벤트 리스너 첫번째");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        JButton btn = new JButton("만지지마");
        JButton btn02 = new JButton("만지지마");
        container.setLayout(new FlowLayout());
        container.add(btn);

        //ActionListener myActionListener = new MyActionListener();
        btn.addActionListener(new MyActionListener());
        // 1. 외부 클래스를 따로 만들어서 처리...
        // 2. 내부 클래스 만들어서 처리

        // 사용자(user)가 이벤트를 발생시켰을때 어떻게 반응해야하는지...

        this.setSize(400,400);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new EventListener01();
    }
}
