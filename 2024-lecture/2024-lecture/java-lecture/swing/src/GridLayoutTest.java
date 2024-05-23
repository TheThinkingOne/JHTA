import javax.swing.*;
import java.awt.*;

public class GridLayoutTest extends JFrame {
    public GridLayoutTest() {
        this.setTitle("grid Layout");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 눌렀을 때 메모리 상에서 지워버리기
        //this.setSize(300,300);

        Container container = this.getContentPane();
//        JPanel jPanel = new JPanel();
//        this.setContentPane(jPanel);

        // BorderLayout / FlowLayout / GridLayout
        container.setLayout(new GridLayout(4,2,10,10));
        JLabel label01 = new JLabel("이름");
        JTextField textField01 = new JTextField(10);

        container.add(label01);
        container.add(textField01);
        container.add(new JLabel("학번"));
        container.add(new JTextField(10));
        container.add(new JLabel("학번"));
        container.add(new JTextField(10));
        container.add(new JLabel("학번"));
        container.add(new JTextField(10));

        this.setVisible(true);
    }
    public static void main(String[] args) {
        new GridLayoutTest();
    }
}
