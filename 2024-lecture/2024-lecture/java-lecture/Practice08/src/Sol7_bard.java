import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Sol7_bard extends JFrame {
    public Sol7_bard() {
        // Use BorderLayout for main frame layout
        this.getContentPane().setLayout(new BorderLayout());

        // Create top panel with FlowLayout
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label01 = new JLabel("수식입력");
        JTextField textField01 = new JTextField(10);
        topPanel.add(label01);
        topPanel.add(textField01);

        // Create center panel with GridLayout (4x4, no spacing)
        JPanel centerPanel = new JPanel(new GridLayout(4, 4, 0, 0));
        for (int i = 0; i < 16; i++) {
            JButton jButton = new JButton(Integer.toString(i));
            centerPanel.add(jButton);
        }

        // Create bottom panel with FlowLayout
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel jLabel02 = new JLabel("계산결과");
        JTextField textField02 = new JTextField(10);
        bottomPanel.add(jLabel02);
        bottomPanel.add(textField02);

        // Add panels to main frame using BorderLayout regions
        this.getContentPane().add(topPanel, BorderLayout.NORTH);
        this.getContentPane().add(centerPanel, BorderLayout.CENTER);
        this.getContentPane().add(bottomPanel, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Sol7();
    }
}
