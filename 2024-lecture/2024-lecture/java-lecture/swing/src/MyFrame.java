import javax.swing.*;
import java.awt.*;


public class MyFrame extends JFrame{
    public MyFrame() {

        Container container = this.getContentPane();
        JButton button01 = new JButton("클릭1");
        JButton button02 = new JButton("클릭2");
        JButton button03 = new JButton("클릭3");
        JButton button04 = new JButton("클릭4");
        JButton button05 = new JButton("클릭5");
        // 컴퍼넌트를 앉힐때 쓰는 레이아웃이 있음... BorderLayout 이 잡힘

        //container.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        container.setLayout(new BorderLayout(10,10));
        //FlowLayout은 옆으로 배치
        //BorderLayout은 동서남북 배치

        container.add(button01, BorderLayout.NORTH);
        container.add(button02, BorderLayout.SOUTH);
        container.add(button03, BorderLayout.EAST);
        container.add(button04, BorderLayout.WEST);
        container.add(button05, BorderLayout.CENTER);

        this.setTitle("타이틀");
        this.setSize(300,300);
        this.setVisible(true);
        // JPanel 에 다른 컴포넌트 가져다 앉힌다.
    }

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
    }
}
