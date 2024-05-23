import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sol2 extends JFrame {
    private JLabel label; // label을 인스턴스 변수로 선언하여 mouseMoved 이벤트에서도 접근 가능하게 함
    private Container container; // container를 인스턴스 변수로 선언하여 mouseMoved 이벤트에서도 접근 가능하게 함

    private boolean isDragging = false;
    public Sol2() throws HeadlessException {
        this.setTitle("Sol2");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container = this.getContentPane();
        container.setLayout(new FlowLayout());
        container.setBackground(Color.green);

        label = new JLabel("당신을 기억해요.");
        label.setOpaque(true);
        label.setSize(80,30);
        container.add(label);

        this.setSize(400,400);
        this.setVisible(true);

        container.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if (!isDragging) { // 마우스 드래그 중이 아닐 때에만 배경색과 텍스트 변경
                    container.setBackground(Color.green);
                    label.setText("Waiting Mouse Dragging");
                }
            }
        });

        container.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                container.setBackground(Color.ORANGE);
                label.setText("Mouse Dragging");
                isDragging = true; // 마우스 드래그 중임을 나타내는 플래그 설정
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isDragging = false; // 마우스 드래그가 끝났음을 나타내는 플래그를 false로 설정
                container.setBackground(Color.ORANGE);
                label.setText("만지지마라");
            }
        });
    }

    public static void main(String[] args) {
        new Sol2();
    }
}


