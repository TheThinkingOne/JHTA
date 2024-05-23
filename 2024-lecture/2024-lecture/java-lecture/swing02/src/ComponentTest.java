import javax.swing.*;
import java.awt.*;

public class ComponentTest extends JFrame {
    public ComponentTest() throws HeadlessException {
        super("삼라만상");

        Container container = this.getContentPane(); // 여기에 컴포넌트 앉히기
        container.setLayout(new FlowLayout());

        JButton btn01 = new JButton("Black / White");
        JButton btn02 = new JButton("나타났다가 / 사라졌다가");
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon("C:\\Users\\중앙HTA\\Desktop\\2024-lecture\\2024-lecture\\2024-lecture\\java-lecture\\swing02\\src\\emoji.png"));

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\중앙HTA\\Desktop\\2024-lecture\\2024-lecture\\2024-lecture\\java-lecture\\swing02\\src\\Mini_Bianca_03.png");
        JButton btn03 = new JButton("",imageIcon);

        btn01.setFont(new Font("맑은 고딕",Font.BOLD,20));
        btn01.setOpaque(true); // 불투명 처리
        btn01.setMargin(new Insets(0,0,0,1)); // 테두리 관련 마진
        //btn01.setRolloverEnabled(false);
        btn01.setBackground(Color.BLACK);
        btn01.setForeground(Color.WHITE);
        btn01.setBorder(null); // 테두리 안보이게 하기
        btn01.setFocusPainted(false); //
        btn01.setBorderPainted(false); //

        btn02.setEnabled(false);

        container.add(btn01);
        container.add(btn02);
        container.add(btn03);
        container.add(imageLabel);

        this.setSize(1000,1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new ComponentTest();
    }
}
