import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Fruit extends JFrame {
    private String fruits[] = new String[10];
    private int count = 1;

    public Fruit() throws HeadlessException {
        super("타이틀 따로 안적어도 됨");
        fruits[0] = "apple";
        fruits[1] = "avocado";
        fruits[2] = "banana";
        fruits[3] = "cherries";
        fruits[4] = "dragon-fruit";
        fruits[5] = "grape";
        fruits[6] = "lemon";
        fruits[7] = "mango";
        fruits[8] = "orange";
        fruits[9] = "watermelon";
        JLabel title = new JLabel("당신이 제일 좋아하는 과일은?");
        title.setFont(new Font("맑은 고딕",Font.BOLD, 24));
        title.setHorizontalAlignment(JLabel.CENTER);
        Container container = this.getContentPane(); //여기에 컴퍼넌트 앉히기...
        //container.setLayout(new BorderLayout());
        container.add(title,BorderLayout.NORTH);
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        JPanel mainPanel = new JPanel();

        JLabel leftImageLabel = new JLabel();
        ResizeIcon leftResizeIcon = new ResizeIcon("fruits/"+fruits[0]+".png");
        leftImageLabel.setIcon(leftResizeIcon.getResizedImage(200,200));
        leftPanel.add(leftImageLabel);

        JLabel rightImageLabel = new JLabel();
        ResizeIcon rightResizeIcon = new ResizeIcon("fruits/"+fruits[1]+".png");
        rightImageLabel.setIcon(rightResizeIcon.getResizedImage(200,200));
        rightPanel.add(rightImageLabel);

        container.add(mainPanel,BorderLayout.CENTER);
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        //container.add(leftPanel,BorderLayout.WEST);
        //container.add(rightPanel,BorderLayout.EAST);
        //순서는 가져야 할거 같다...

        leftPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                ResizeIcon rightImageIcon = new ResizeIcon("fruits/"+fruits[count]+".png");
                rightImageLabel.setIcon(rightImageIcon.getResizedImage(200,200));
                count++;
                if (count > fruits.length) {
                    rightPanel.setVisible(false);
                    leftPanel.removeMouseListener(this);
                }

            }
        });

        rightPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                ResizeIcon leftImageIcon = new ResizeIcon("fruits/"+fruits[count]+".png");
                leftImageLabel.setIcon(leftImageIcon.getResizedImage(200,200));
                count++;
                if (count > fruits.length) {
                    leftPanel.setVisible(false);
                    rightPanel.removeMouseListener(this);
                }
            }
        });



        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Fruit();
    }
}
