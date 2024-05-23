import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Fruit extends JFrame {
    private String fruits[] = new String[10];
    private int count=1;

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
        ImageIcon leftImageIcon = new ImageIcon("fruits/"+fruits[0]+".png");
        Image leftImage = leftImageIcon.getImage();
        Image leftResizeImage = leftImage.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        ImageIcon leftImageResizeIcon = new ImageIcon(leftResizeImage);
        leftImageLabel.setIcon(leftImageResizeIcon);

        JLabel rightImageLabel = new JLabel();
        ImageIcon rightImageIcon = new ImageIcon("fruits/"+fruits[1]+".png");
        Image rightImage = rightImageIcon.getImage();
        Image rightResizeImage = rightImage.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        ImageIcon rightImageResizeIcon = new ImageIcon(rightResizeImage);
        leftImageLabel.setIcon(leftImageResizeIcon);
        leftPanel.add(leftImageLabel);

        rightImageLabel.setIcon(rightImageResizeIcon);
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
                count++;
                System.out.println("왼쪽 눌렀음");
                ImageIcon rightImageIcon = new ImageIcon("fruits/"+fruits[count]+".png");
                Image rightImage = rightImageIcon.getImage();
                Image rightResizeImage =
                        rightImage.getScaledInstance(200,200,Image.SCALE_SMOOTH);
                ImageIcon rightImageResizeIcon = new ImageIcon(rightResizeImage);
                rightImageLabel.setIcon(rightImageResizeIcon);
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
