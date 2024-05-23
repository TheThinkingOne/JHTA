package ex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class MyMouseAdapter extends MouseAdapter {
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouser Adapter 재정의");
    }
}

public class EventListener04 extends JFrame {
    private JLabel label = null;

    public EventListener04() throws HeadlessException {
        this.setTitle("이벤트 리스너 첫번째");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(null);

        label = new JLabel("안녕");
        label.setSize(30,30);
        container.add(label);
        // 어뎁터: 대체 하는것
        // Key, Mouse, MouseMotion, Focus 등등 ActionListener는 하나밖에 없어서 adapter 없음
        // 노트북 전원장치...
        // MouserAdaper 는 추상클래스 이므로 직접 생성해서 쓰는 건 안된다.
        // interface도 마찬가지.
        // MouseAdapter의 익명 자식 클래스를 정의하는 것
        container.addMouseListener(new MouseAdapter() {
            // 마우스 어뎁터는 필요한 기능 하나만 오버로드 해서 사용할 수 있음
            @Override
            public void mousePressed(MouseEvent e) {
                label.setLocation(e.getX(),e.getY());
            }
        });

        container.addMouseListener(new MyMouseAdapter());

        this.setSize(400,400);
        this.setVisible(true);
    }


    public static void main(String[] args) {
        new EventListener04();
    }
}
