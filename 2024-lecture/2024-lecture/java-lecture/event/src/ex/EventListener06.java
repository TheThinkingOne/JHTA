package ex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventListener06 extends JFrame {

    private JLabel label = new JLabel();

    public int num = 10;

    public EventListener06() throws HeadlessException {

        this.setTitle("이벤트 리스너 첫번째");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new FlowLayout());
        container.add(label);

        label.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                System.out.println(e.getWheelRotation());
                if (e.getWheelRotation()<0) {

                }
            }
        });

        MyMouseListener myMouseListener = new MyMouseListener();
        container.addMouseListener(myMouseListener);
        container.addMouseMotionListener(myMouseListener);

        label.setText("마우스 이벤트 종류를 알아보자");
        // key event를 받으려면 focus 가 있어야 함

        this.setSize(400,400);
        this.setVisible(true);

        container.setFocusable(true);
        container.requestFocus(); // 포커스를 받는다

    }

    class MyMouseListener implements MouseListener, MouseMotionListener {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            label.setText("mouse pressed (" + x + "," + y + ")");
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            System.out.println("마우스가 해당 영역에 진입했을 때(올라갔을 때) 출력");
            Container container = (Container)e.getSource();
            container.setBackground(Color.GREEN);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            System.out.println("마우스가 해당 영역을 벗어날을 때");
            Container container = (Container)e.getSource();
            container.setBackground(null);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            label.setText("mouse dragged (" + x + "," + y + ")");
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            label.setText("mouse moved (" + x + "," + y + ")");
        }
    } // 추상클래스 다중상속 가능

    public static void main(String[] args) {
        new EventListener06();
    }
}