import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MyMouseAdapter extends MouseAdapter {
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouser Adapter 재정의");
    }
}

public class Sol6 extends JFrame {
    private JLabel label = null;

    public Sol6() throws HeadlessException {
        this.setTitle("Sol6");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(null);

        label = new JLabel("하늘을 달리다");
        // Set preferred size based on text
        label.setPreferredSize(new Dimension(label.getPreferredSize().width, label.getPreferredSize().height));
        label.setSize(label.getPreferredSize());
        label.setLocation(100, 100);
        container.add(label);
        container.addMouseListener(new MouseAdapter() {
            // 마우스 어뎁터는 필요한 기능 하나만 오버로드 해서 사용할 수 있음
            @Override
            public void mousePressed(MouseEvent e) {
                label.setLocation((int) (Math.random() * 350 + 50), (int) (Math.random() * 350 + 50));
            }
        });

        container.addMouseListener(new MyMouseAdapter());

        this.setSize(400, 400);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Sol6();
    }
}
