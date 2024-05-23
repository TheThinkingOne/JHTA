import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

class MouseDrawPanel extends JPanel {
    private List<Point> startPoints = new ArrayList<>();
    private List<Point> endPoints = new ArrayList<>();
    private List<Point> oldPoint = new ArrayList<>();

    public MouseDrawPanel() {
        // 두 개의 이벤트 필요 (MousePressed, MouseReleased)
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                startPoints.add(e.getPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                endPoints.add(e.getPoint());
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

public class MouseDraw extends JFrame {
    private MouseDrawPanel graphicsPanel = new MouseDrawPanel();
    private MouseDraw() throws HeadlessException {
        this.setTitle("MouseDraw");
        this.setSize(500,400);
        this.setContentPane(graphicsPanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MouseDraw();
    }
}
