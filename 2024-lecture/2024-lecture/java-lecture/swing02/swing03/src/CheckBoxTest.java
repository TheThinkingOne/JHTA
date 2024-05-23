import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckBoxTest extends JFrame {
    public CheckBoxTest() throws HeadlessException {
        super("삼라만상");

        Container container = this.getContentPane(); // 여기에 컴포넌트 앉히기
        container.setLayout(new FlowLayout());

        JCheckBox checkBox01 = new JCheckBox("사과");
        JCheckBox checkBox02 = new JCheckBox("바나나");
        JCheckBox checkBox03 = new JCheckBox("아보카도");

        checkBox01.addItemListener(new ItemListener() { // 체크박스는 ItemListener 달아야 한다
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED) {
                    System.out.println("checked");
                } else {
                    System.out.println("unchecked");
                }
            }
        });

        container.add(checkBox01);
        container.add(checkBox02);
        container.add(checkBox03);



        this.setSize(1000,1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new CheckBoxTest();
    }
}
