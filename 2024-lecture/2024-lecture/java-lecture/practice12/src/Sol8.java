import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.List;

// 위쪽 단어 나오는 부분
class GamePanel extends JPanel implements Runnable {
    //JLabel에 뽑혀진 word넣고 아래로 내려오게 하기...
    Thread thread = new Thread(this);
    private JLabel label = new JLabel();
    private JLabel resultLabel = new JLabel();

    private String word = null;
    Words words = new Words("src/data/word");

    public boolean correctWord(String inputWord) {
        if(word.equals(inputWord)) return true;
        else return false;
    }

    public void startGame() {
        // 글자 다시 뽑고
        // 위치 바꾸고
        // 내려오게 하기...
        word = words.getRandomWord();
        label.setText(word);
        label.setSize(100,30);
        label.setLocation(100,-50);

        thread = new Thread(this);
        thread.start();
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                // 누르고 있는 동안 setX()를 바꾸기
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public void stopGame() {
        thread.interrupt(); // 스레드 종료
    }

    public void setResultLabel(String txt) {
        resultLabel.setText("결과 : " + txt);
    }

    public GamePanel() {
        word = words.getRandomWord();
        System.out.println("word==="+word);

        resultLabel.setText("결과 : ");
        resultLabel.setLocation(20,20);
        resultLabel.setSize(100,30);
        this.add(resultLabel);

        label.setText(word);
        this.setLayout(null);
        this.add(label);
        label.setLocation(100,-50);
        label.setSize(100,30);
        this.setBackground(Color.LIGHT_GRAY);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            label.setLocation(100,label.getY()+1);
            if (label.getY()>this.getHeight()+50) {
                System.out.println("내려갔음");
                label.setText("");
                setResultLabel("시간 초과 볍신아!");
                stopGame();
                startGame();
            }
            this.repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
//아래쪽 입력 부분
class InputPanel extends JPanel {
    GamePanel gamePanel = new GamePanel();
    private JTextField input = new JTextField(15);
    public InputPanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        //System.out.println("==="+gamePanel.word);
        this.setBackground(Color.GRAY);
        this.add(input);
        //이벤트를 걸어야함....
        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //엔터키만 인식...
                //System.out.println("엔터");
                //여기에 맞는지 틀린지 비교
                String txt = input.getText();
                if(txt.equals("exit")) {
                    System.exit(0); //이러면 frame 종료
                }
                if(gamePanel.correctWord(txt)) {
                    System.out.println("맞았습니다");
                    gamePanel.stopGame();
                    gamePanel.startGame();
                    gamePanel.setResultLabel("제법인데?");

                } else {
                    gamePanel.setResultLabel("허접~");
                }
                // 떨어지는 단어 위치가 화면 넘어가면 다시 게임 시작
                input.setText("");
                //if(txt.equals())
                // 글자 만드는건 gamePanel 에서

            }
        });

    }
}
class Words {
    private List<String> words = new ArrayList<>();

    public Words(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext()) {
                String word = scanner.nextLine(); //한줄읽기
                words.add(word);
            }
            scanner.close(); //이거해야지만 가비지의 수집 대상이 된다.
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    //words에서 word 하나 뽑기...
    public String getRandomWord() {
        int total = words.size();
        int idx = (int)(Math.random()*total);
        return words.get(idx);
    }
}
public class Sol8 extends JFrame {
    private GamePanel gamePanel = new GamePanel();
    private InputPanel inputPanel = new InputPanel(gamePanel);

    public Sol8() throws HeadlessException {
        //Words words = new Words("data/words.txt");
        //System.out.println(words.getRandomWord());
        this.setTitle("워드 게임");
        this.setSize(640,440);
        Container container = this.getContentPane();
        container.add(gamePanel,BorderLayout.CENTER);
        container.add(inputPanel,BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Sol8();
    }
}

