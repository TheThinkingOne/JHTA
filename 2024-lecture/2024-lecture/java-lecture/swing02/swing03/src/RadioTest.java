import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RadioTest extends JFrame {
    public RadioTest() throws HeadlessException {
        super("삼라만상");

        Container container = this.getContentPane(); // 여기에 컴포넌트 앉히기
        container.setLayout(new FlowLayout());

        JRadioButton radio01 = new JRadioButton("사과");
        JRadioButton radio02 = new JRadioButton("바나나");
        JRadioButton radio03 = new JRadioButton("아보카도");

        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(radio01);
        radioGroup.add(radio02);
        radioGroup.add(radio03);

        radio01.addItemListener(new ItemListener() { // 체크박스는 ItemListener 달아야 한다
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println(e.getStateChange());
                System.out.println("radio01.isSelected()=="+radio01.isSelected());

                if(e.getStateChange()==ItemEvent.SELECTED) {
                    System.out.println("checked");
                } else {
                    System.out.println("unchecked");
                }
            }
        });

        container.add(radio01);
        container.add(radio02);
        container.add(radio03);

        this.setSize(1000,1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new RadioTest();
    }
}