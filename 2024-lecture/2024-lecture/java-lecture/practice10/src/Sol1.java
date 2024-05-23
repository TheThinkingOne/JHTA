import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Sol1 extends JFrame {
    public Sol1() throws HeadlessException {
        super("삼라만상");

        Container container = this.getContentPane(); // 여기에 컴포넌트 앉히기
        container.setLayout(new FlowLayout());

        JCheckBox checkBox01 = new JCheckBox("버튼 비활성화");
        JCheckBox checkBox02 = new JCheckBox("버튼 감추기");
        JButton btn = new JButton("만지지마");

        container.add(checkBox01);
        container.add(checkBox02);
        container.add(btn);

        checkBox01.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                //System.out.println("check");
                if(e.getStateChange()==ItemEvent.SELECTED) {
                    btn.setEnabled(false);
                } else {
                    btn.setEnabled(true);
                }
            }
        });

        checkBox02.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                //System.out.println("check");
                if(e.getStateChange()==ItemEvent.SELECTED) {
                    btn.setVisible(false);
                } else {
                    btn.setVisible(true);
                }
            }
        });



        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new Sol1();
    }
}