import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class GameThread extends Thread {
    private JLabel labels [];
    private JLabel resultLabel;

    public GameThread(JLabel[] labels, JLabel resultLabel) {
        this.labels = labels;
        this.resultLabel = resultLabel;
    }

    // 스레드 깨우는 메서드 생성
    synchronized public void StartGame() {
        this.notify(); // 스레드 깨우기
    }
    synchronized public void WaitGame() {
        try {
            this.wait();
            // 대기 명령
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while (true) {
            WaitGame();
            try {
                int random01 = (int) (Math.random() * 3 + 1);
                int random02 = (int) (Math.random() * 3 + 1);
                int random03 = (int) (Math.random() * 3 + 1);

                labels[0].setForeground(Color.BLUE);
                Thread.sleep(500);
                labels[0].setForeground(Color.ORANGE);
                labels[0].setText(Integer.toString(random01));

                labels[1].setForeground(Color.BLUE);
                Thread.sleep(500);
                labels[1].setForeground(Color.ORANGE);
                labels[1].setText(Integer.toString(random02));

                labels[2].setForeground(Color.BLUE);
                Thread.sleep(500);
                labels[2].setForeground(Color.ORANGE);
                labels[2].setText(Integer.toString(random03));

                if(random01==random02 && random02==random03) {
                    resultLabel.setText("빙고!");
                } else {
                    resultLabel.setText("Try Again ㅋ");
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class GamePanel extends JPanel {
    private JLabel labels[] = new JLabel[3];
    private JLabel resultLabel = new JLabel("You will cum in 30 seconds");

    GameThread gameThread = new GameThread(labels, resultLabel);

    public GamePanel() {
        this.setLayout(null); // 자유배치
        for(int i=0; i<3; i++) {
            labels[i] = new JLabel("0");
            labels[i].setSize(50,50);
            labels[i].setLocation(60*i+50,50);
            labels[i].setHorizontalAlignment(JLabel.CENTER);
            labels[i].setOpaque(true);
            labels[i].setBackground(Color.LIGHT_GRAY);
            labels[i].setFont(new Font("맑은 고딕",Font.BOLD,36));
            this.add(labels[i]);
        }

        this.add(resultLabel);
        resultLabel.setSize(300,50);
        resultLabel.setLocation(60,150);
        gameThread.start();
        //resultLabel.setSize(300,50);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("마우스 클릭");
                gameThread.StartGame(); // 스레드 깨우기
            }
        });

    }
}

public class WaitThreadTest extends JFrame {
    public WaitThreadTest() throws HeadlessException {
        this.setTitle("Wait");
        this.setSize(500,300);

        this.setContentPane(new GamePanel());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new WaitThreadTest();
    }
}
