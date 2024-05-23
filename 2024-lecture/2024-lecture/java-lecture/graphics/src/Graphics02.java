import javax.swing.*;
import java.awt.*;

class MyPanel03 extends JPanel {
    public ImageIcon imageIcon = new ImageIcon("src/images/KakaoTalk_20240408_101635921_02.jpg");
    private Image image = imageIcon.getImage();

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setClip(100,100,100,100); // 마스크 clipping path
        g.drawImage(image,0,0,this.getWidth(),this.getHeight(),this); // 옵저버(감시자)
    }
}

public class Graphics02 extends JFrame {
    private MyPanel03 graphicsPanel = new MyPanel03();
    public Graphics02() throws HeadlessException {
        this.setTitle("Graphics");
        this.setSize(500,500);
        this.setContentPane(graphicsPanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Graphics02();
    }
}
