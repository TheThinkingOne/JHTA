import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Sol8_GPT extends JFrame {
    private JLabel[] labels = new JLabel[3];
    private JLabel resultLabel;

    public Sol8_GPT() throws HeadlessException {
        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        labels[0] = new JLabel("0");
        labels[1] = new JLabel("0");
        labels[2] = new JLabel("0");

        resultLabel = new JLabel("운명만큼이나 중요한건 우리의 의지죠.");

        setSize(400, 400);
        setTitle("Sol8");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JFrame에 포커스 설정
        setFocusable(true);
        requestFocusInWindow();

        // JFrame에 KeyListener 추가
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    gamble();
                }
            }
        });

        for (int i = 0; i < 3; i++) {
            container.add(labels[i]);
            labels[i].setOpaque(true);
            labels[i].setFont(new Font("MaruBuri-Bold", Font.BOLD, 30));
            labels[i].setBackground(Color.MAGENTA);
            labels[i].setSize(80, 30);
        }

        container.add(resultLabel);

        setVisible(true);
    }

    private void gamble() {
        // 각 레이블의 텍스트를 가져와 정수로 변환
        int num1 = Integer.parseInt(labels[0].getText());
        int num2 = Integer.parseInt(labels[1].getText());
        int num3 = Integer.parseInt(labels[2].getText());

        // 결과 판단 및 resultLabel 텍스트 변경
        if (num1 == num2 && num2 == num3) {
            resultLabel.setText("말하는대로 이루어져라!");
        } else {
            resultLabel.setText("괜찮아~ 서툴러도 돼.");
        }

        // 각 레이블에 0부터 3까지의 랜덤한 수 할당
        for (int i = 0; i < 3; i++) {
            labels[i].setText(Integer.toString((int) (Math.random() * 4))); // 0부터 3까지의 난수 발생
        }
    }

    public static void main(String[] args) {
        new Sol8_GPT();
    }
}



