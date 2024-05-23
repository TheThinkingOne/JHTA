package ex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyKeyListener extends JFrame {

}

public class EventListener05 extends JFrame {
    private JLabel labels[] = new JLabel[3];

    public EventListener05() throws HeadlessException {
        labels[0] = new JLabel("aa");
        labels[1] = new JLabel("bb");
        labels[2] = new JLabel("cc");


        this.setTitle("이벤트 리스너 첫번째");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(null);
        // key event를 받으려면 focus 가 있어야 함
        container.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                labels[0].setText(Integer.toString(e.getKeyCode()));
                labels[1].setText(Character.toString(e.getKeyChar()));

                System.out.println(e.getKeyCode()); // 입력한 CHAR의 유니코드 번호 반환
                System.out.println(e.getKeyChar());
                if(e.getKeyCode()==KeyEvent.VK_LEFT) {
                    container.setBackground(Color.ORANGE);
                    labels[0].setLocation(labels[0].getX()-10,labels[0].getY()); // 키보드 좌우키 누르면 좌우 10픽셀씩 이동
                } else if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
                    container.setBackground(Color.green);
                    labels[0].setLocation(labels[0].getX()+10,labels[0].getY());
                }
            }
        });
        for (int i=0; i<3; i++) {
            container.add(labels[i]);
            labels[i].setOpaque(true);
            labels[i].setBackground(Color.ORANGE);
            labels[i].setSize(80,30);
        }

        this.setSize(400,400);
        this.setVisible(true);
        container.setFocusable(true);
        container.requestFocus(); // 포커스를 받는다

    }


    public static void main(String[] args) {
        new EventListener05();
    }
}