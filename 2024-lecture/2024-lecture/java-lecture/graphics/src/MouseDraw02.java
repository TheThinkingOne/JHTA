import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

class MouseDrawPanel02 extends JPanel {
    private List<Point> startPoints = new ArrayList<>();
    private List<Point> endPoints = new ArrayList<>();
    Point oldPoint = null;

    public MouseDrawPanel02() {
        // del 키 누르면 그림 전부 지우기
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==KeyEvent.VK_DELETE) {
                    startPoints.clear();
                    endPoints.clear();
                    repaint();
                }
            }
        });
        // 두 개의 이벤트 필요 (MousePressed, MouseReleased)
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mousePressed(e);
                startPoints.add(oldPoint);
                endPoints.add(e.getPoint());
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseReleased(e);
                startPoints.add(e.getPoint());
                oldPoint = e.getPoint();
                repaint();
            }
        });
    }

    public void paintComponent(Graphics g) {
        // repaint
        super.paintComponent(g);
        // 여기에 그림그리기
        g.drawLine(100,100,300,300);
        for(int i=0; i<endPoints.size(); i++) {
            int x1 = (int)this.startPoints.get(i).getX();
            int y1 = (int)this.startPoints.get(i).getY();

            int x2 = (int)this.endPoints.get(i).getX();
            int y2 = (int)this.endPoints.get(i).getY();

            g.drawLine(x1,y1,x2,y2);
        }
    }

}

public class MouseDraw02 extends JFrame {
    private MouseDrawPanel02 graphicsPanel = new MouseDrawPanel02();
    private MouseDraw02() throws HeadlessException {
        this.setTitle("MouseDraw");
        this.setSize(500,400);
        this.setContentPane(graphicsPanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MouseDraw02();
    }
}
