import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Sol2 extends JFrame {
    public Sol2() throws HeadlessException {
        super("삼라만상");

        Container container = this.getContentPane(); // 여기에 컴포넌트 앉히기
        container.setLayout(new FlowLayout());

        JTextField jTextField = new JTextField(12);
        JComboBox<String> comboBox = new JComboBox<>();

        container.add(jTextField);
        container.add(comboBox);

        jTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = jTextField.getText();
                System.out.println("글을 입력합니다.");
                if (!str.equals("")) {
                    comboBox.addItem(jTextField.getText());
                    jTextField.setText("");
                }
            }
        });


        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new Sol2();
    }
}
