import javax.swing.*;
import java.awt.*;


class MyPanel02 extends JPanel {
    public void paintComponent(Graphics g) {
        // 여기다가 그림그리기
        // 컬러 정하기
        // draw, fill 등등
        g.setColor(new Color(222, 141, 18));
        g.drawRect(100,400,20,200);

        g.setColor(new Color(222, 141, 18));
        g.drawRect(130,200,20,250);

        // 글자 그리기 컬러 정하기 폰트 정하기
        g.setColor(new Color(199,82,34));
        g.setFont(new Font("맑은 고딕",Font.BOLD,30));
        g.drawString("JAVA",30,20);

        g.drawLine(150,150,300,300);
        g.fillOval(300,300,100,100);
        g.drawRoundRect(300,20,100,100,30,30);
        g.drawArc(300,200,100,100,30,330);

        int x[] = {100,50,100,150};
        int y[] = {100,150,200,150};
        g.drawPolygon(x,y,4);

    }
}
public class Graphics01 extends JFrame {
    private MyPanel02 graphicsPanel = new MyPanel02();
    public Graphics01() throws HeadlessException {
        this.setTitle("Graphics");
        this.setSize(500,500);

        this.setContentPane(graphicsPanel);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Graphics01();
    }
}
