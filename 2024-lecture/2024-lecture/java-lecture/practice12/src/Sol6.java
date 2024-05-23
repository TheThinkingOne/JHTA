import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Bubble extends JLabel implements Runnable {
    BubblePanel bubblePanel;
    public Bubble(BubblePanel bubblePanel,int posX, int posY) {
        System.out.println("나는 풍선 레이블");
        ImageIcon imageIcon = new ImageIcon("src/images/newEmma3.png");
        this.setIcon(imageIcon);
        this.setSize(imageIcon.getIconWidth(),imageIcon.getIconHeight());
        this.setLocation(posX - imageIcon.getIconWidth()/2 ,posY - imageIcon.getIconHeight()/2);
        bubblePanel.add(this);
        bubblePanel.repaint();
        Thread thread = new Thread(this);
        thread.start();
        this.bubblePanel = bubblePanel;
    }

    //이미지 큰거 가져온 사람 이미지 줄이기
    /*
    public Bubble(int posX, int posY) {
        System.out.println("나는 풍선 레이블");
        ImageIcon imageIcon = new ImageIcon("images/balloon.png");
        Image image = imageIcon.getImage();
        Image resizeImage = image.getScaledInstance(16,16,Image.SCALE_SMOOTH);
        ImageIcon resizeImageIcon = new ImageIcon(resizeImage);
        this.setIcon(resizeImageIcon);
        this.setSize(resizeImageIcon.getIconWidth(),resizeImageIcon.getIconHeight());
        this.setLocation(posX - resizeImageIcon.getIconWidth()/2 ,posY - resizeImageIcon.getIconHeight()/2);
    }
     */

    @Override
    public void run() {
        int loadX = this.getX();
        int loadY = this.getY();
        int speedX = loadX;
        int radius = (int)(Math.random()*20+10);
        double theta = 0;
        while(true) {
            //여기에 실행코드
            theta+=0.02;  // 주기
            speedX = (int)(Math.sin(theta)*radius)+loadX;   //-1~1
            loadY-=1;
            this.setLocation(speedX,loadY);
            //thread 지워야함...
            if(loadY<100) {
                // 더 이상 화면에 없음
                //화면에서 지워야함...
                bubblePanel.remove(this);
                bubblePanel.repaint();
                return;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class BubblePanel extends JPanel {

    public BubblePanel() {
        //여기다가 JLabel(이미지 아이콘)
        System.out.println("BubblePanel 생성");
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("마우스 클릭");
                //new Bubble(마우스 x, 마우스 y);
                Bubble bubble = new Bubble(BubblePanel.this,e.getX(),e.getY());
                //add(bubble);
                //repaint();

            }
        });
        this.setLayout(null);
    }
}
public class Sol6 extends JFrame {
    public Sol6() throws HeadlessException {
        this.setTitle("타이머");
        this.setSize(500,500);
        this.setContentPane(new BubblePanel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Sol8();
    }
}
