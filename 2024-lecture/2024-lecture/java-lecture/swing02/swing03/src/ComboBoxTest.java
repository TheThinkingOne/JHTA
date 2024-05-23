import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.Vector;

public class ComboBoxTest extends JFrame {
    private String fruits[] = {"apple","banana","avocado"};
    public ComboBoxTest() throws HeadlessException {
        super("삼라만상");

        Container container = this.getContentPane(); // 여기에 컴포넌트 앉히기
        container.setLayout(new FlowLayout());

        JComboBox<String> comboBox = new JComboBox<>(fruits);
        Vector<String> fruits02 = new Vector<>(Arrays.asList(fruits));
        JComboBox<String> comboBox02 = new JComboBox<>(fruits02); // comboBox에 vector 투입이 된다

        container.add(comboBox);
        container.add(comboBox02);

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(comboBox.getSelectedIndex());
            }
        });

        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new ComboBoxTest();
    }
}
